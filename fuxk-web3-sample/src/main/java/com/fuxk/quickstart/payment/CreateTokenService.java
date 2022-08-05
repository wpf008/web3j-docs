package com.fuxk.quickstart.payment;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateTokenService {

    private static CloseableHttpClient httpClient;

    static RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(10000)
            .setConnectTimeout(10000)
            .setSocketTimeout(10000)
            .build();

    static {
        httpClient = HttpClients.createDefault();
    }

    private static String polygonUrl = "https://matic-mumbai.chainstacklabs.com";

    private static Web3j polygonWeb3j = Web3j.build(new HttpService(polygonUrl));

    private static String factoryAddress = "0x276b202dD4b3b69EF479290F78D54A8f585996DB";


    public void getNonce() {
        Credentials credentials = Credentials.create("5e165b0f5b6589f2f05aaf0de475629c71fb5e6fb99dc3f6801b6b6c675139f4");
        System.out.println("private key: " + credentials.getAddress());
        EthGetTransactionCount transactionCount = null;
        try {
            transactionCount = polygonWeb3j.ethGetTransactionCount(credentials.getAddress(),
                    DefaultBlockParameterName.LATEST).sendAsync().get(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        BigInteger nonce = transactionCount.getTransactionCount();
        System.out.printf("nonce is " + nonce.toString());
    }

    public NftTransactionRecord mintBatch1155Token(MintBatchRequest mintBatch1155Request) {
        return mint(mintBatch1155Request, "mintBatch_1155", factoryAddress);
    }


    private NftTransactionRecord mint(MintBatchRequest mintBatchRequest, String functionName, String address) {
        try {
            String contractAddress = mintBatchRequest.getContractAddress();
            String to = mintBatchRequest.getAddress();
            List<Integer> quantities = mintBatchRequest.getQuantity();

            List<Uint256> _quantities = new ArrayList<>();

            for (Integer quantity : quantities) {
                _quantities.add(new Uint256(BigInteger.valueOf(quantity)));
            }
            long chainId = polygonWeb3j.ethChainId().send().getChainId().longValue();
            System.out.println(" ================ chainId is " + chainId + "======================");
            BigInteger maxPriorityFeePerGas = queryEthMaxPriorityFeePerGas(polygonUrl);
            BigInteger baseFee = queryEthBaseFeePerGas(polygonUrl, "latest");
            BigInteger add = baseFee.add(maxPriorityFeePerGas);
            BigInteger maxFee = add.multiply(BigInteger.valueOf(mintBatchRequest.getGasFactor())).divide(BigInteger.valueOf(10));
            maxPriorityFeePerGas = maxPriorityFeePerGas.divide(BigInteger.valueOf(10));
            Credentials credentials = Credentials.create("5e165b0f5b6589f2f05aaf0de475629c71fb5e6fb99dc3f6801b6b6c675139f4");
            System.out.println("private key: " + credentials.getAddress());
            EthGetTransactionCount transactionCount = polygonWeb3j.ethGetTransactionCount(credentials.getAddress(),
                    DefaultBlockParameterName.LATEST).sendAsync().get(3, TimeUnit.MINUTES);
            BigInteger nonce = transactionCount.getTransactionCount();
            if (mintBatchRequest.getNonce() != -1) {
                nonce = BigInteger.valueOf(mintBatchRequest.getNonce());
                maxPriorityFeePerGas = maxPriorityFeePerGas.multiply(BigInteger.valueOf(100));
                maxFee = maxFee.multiply(BigInteger.valueOf(100));
            }
            System.out.println("maxPriorityFeePerGas is " + maxPriorityFeePerGas.toString() + " maxFee is " + maxFee.toString());
            System.out.println(" ================ nonce is " + nonce.toString() + " ======================");
            //创建交易管理对象
            RawTransactionManager transactionManager = new RawTransactionManager(polygonWeb3j, credentials, chainId);
            List<Type> inputParameters = Arrays.<Type>asList(new Address(contractAddress),
                    new Address(to),
                    new DynamicArray<Uint256>(Uint256.class, _quantities)
            );
            Function function = new Function(functionName, inputParameters, Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
            }));
            String data = FunctionEncoder.encode(function);
            BigInteger gasLimit = getGasLimit(credentials.getAddress(), nonce, address, data);
            System.out.println(" ================ gasLimit is " + gasLimit + " ======================");
            //创建交易对象
            RawTransaction rawTransaction = RawTransaction.createTransaction(
                    chainId,
                    nonce,
                    gasLimit,
                    address,
                    null,
                    data,
                    maxPriorityFeePerGas,
                    maxFee
            );
            //签名并发送交易

            EthSendTransaction transactions = transactionManager.signAndSend(rawTransaction);
            System.out.println(transactions.toString());
            System.out.println("=====交易完成===== txHash is " + transactions.getTransactionHash());
//            System.out.println("=====交易完成===== RawResponse is " + transactions.getRawResponse());
            if(transactions.getError()!=null){
                System.out.println("=====交易失败===== error is " + transactions.getError().getMessage());
            }

            NftTransactionRecord nftTransactionRecord = new NftTransactionRecord();
            nftTransactionRecord.setTxHash(transactions.getTransactionHash());
            nftTransactionRecord.setPaymentAddress(credentials.getAddress());
            nftTransactionRecord.setStatus(2);
            nftTransactionRecord.setGas(gasLimit);
            nftTransactionRecord.setNonce(nonce);
            nftTransactionRecord.setContractAddress(contractAddress);
            String uuids = JSON.toJSONString(mintBatchRequest.getUuids());
            nftTransactionRecord.setUuids(uuids);
            nftTransactionRecord.setNftId(mintBatchRequest.getNftId());
            return nftTransactionRecord;
        } catch (Exception e) {
            System.out.println("mintBatch交易发送错误: " + e.getMessage());
            return null;
        }

    }

    private BigInteger getGasLimit(String paymentAddress, BigInteger nonce, String address, String data) {
        try {
            String gasLimitString = polygonWeb3j.ethEstimateGas(new Transaction
                    (paymentAddress,
                            nonce,
                            null,
                            null,
                            address,
                            null,
                            data)).send().getResult();
            if (gasLimitString != null) {
                return new BigInteger(gasLimitString.substring(2), 16);
            }
        } catch (Exception e) {
            System.out.println("getGasLimit error : " + e.getMessage());
        }
        return BigInteger.valueOf(120000L);
    }


    public static BigInteger queryEthMaxPriorityFeePerGas(String url) {

        try {
            JsonRpcRequest<Object> object = new JsonRpcRequest<>();
            object.setMethod("eth_maxPriorityFeePerGas");
            object.setParams(new ArrayList<>());

            String jsonBody = JSON.toJSONString(object);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            StringEntity entity = new StringEntity(jsonBody, ContentType.create("application/json", "utf-8"));

            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = getBody(httpPost, response);

            JsonRpcResponse jsonRpcResponse = JSON.parseObject(result, JsonRpcResponse.class);

            String priorityFee = jsonRpcResponse.getResult().toString();

            if (priorityFee == null) {
                return null;
            }

            return new BigInteger(priorityFee.substring(2), 16);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static BigInteger queryEthBaseFeePerGas(String url, String blockNumber) {

        try {
            JsonRpcRequest<Object> object = new JsonRpcRequest<>();
            object.setMethod("eth_getBlockByNumber");
            List<Object> list = new ArrayList<>();
            list.add(blockNumber);
            list.add(false);
            object.setParams(list);

            String jsonBody = JSON.toJSONString(object);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            StringEntity entity = new StringEntity(jsonBody, ContentType.create("application/json", "utf-8"));

            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = getBody(httpPost, response);

            JsonRpcResponse jsonRpcResponse = JSON.parseObject(result, JsonRpcResponse.class);

            BaseFee baseFee = JSON.parseObject(jsonRpcResponse.getResult().toString(), BaseFee.class);

            if (baseFee == null) {
                return null;
            }

            String baseFeePerGas = baseFee.getBaseFeePerGas();

            if (baseFeePerGas == null) {
                return null;
            }

            return new BigInteger(baseFeePerGas.substring(2), 16);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static TransactionByHash queryEthTransactionByHash(String url, String txHash) {


        TransactionByHash transactionByHash = new TransactionByHash();
        try {
            JsonRpcRequest<Object> object = new JsonRpcRequest<>();

            object.setMethod("eth_getTransactionByHash");
            List<Object> list = new ArrayList<>();
            list.add(txHash);
            object.setParams(list);

            String jsonBody = JSON.toJSONString(object);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            StringEntity entity = new StringEntity(jsonBody, ContentType.create("application/json", "utf-8"));

            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = getBody(httpPost, response);

            JsonRpcResponse jsonRpcResponse = JSON.parseObject(result, JsonRpcResponse.class);

            transactionByHash = JSON.parseObject(jsonRpcResponse.getResult().toString(), TransactionByHash.class);

            return transactionByHash;

        } catch (Exception e) {
            e.printStackTrace();
            return transactionByHash;
        }

    }

    public static String getBody(HttpRequestBase httpRequestBase, CloseableHttpResponse response) throws IOException {
        String body = "";
        try {
            if (response != null) {
                HttpEntity entity2 = response.getEntity();
                if (entity2 != null) {
                    body = EntityUtils.toString(entity2, "UTF-8");
                }
                EntityUtils.consume(entity2);
            }
        } finally {
            if (httpRequestBase != null) {
                httpRequestBase.releaseConnection();
            }
            if (null != response) {
                response.close();
            }
        }
        return body;
    }

    @Data
    static class JsonRpcRequest<S> {
        private long id = 1;
        private String jsonrpc = "2.0";
        private String method;
        private List<S> params;
    }

    @Data
    static class JsonRpcResponse<T> {
        private long id;
        private T result;
        private String jsonrpc;
        private Response.Error error;
    }

    @Data
    static class BaseFee {
        private String baseFeePerGas;
    }
}
