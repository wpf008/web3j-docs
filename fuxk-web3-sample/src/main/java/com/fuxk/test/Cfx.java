package com.fuxk.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/4 14:23
 */
public class Cfx {

    //
    protected static CloseableHttpClient httpClient;

    static RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(10000)
            .setConnectTimeout(10000)
            .setSocketTimeout(10000)
            .build();

    static {
        httpClient = HttpClients.createDefault();
    }

//    static Web3j cfx = Web3j.build(new HttpService("http://main.confluxrpc.com"));

    public static void main(String[] args) throws IOException {
        String data = "[{\"jsonrpc\":\"2.0\",\"method\":\"cfx_call\",\"params\":[{\"from\":null,\"to\":\"cfx:acc370g3s6d56ndcp8t6gyc657rhtp0fz6ytc8j9d2\"," +
                "\"gasPrice\":null,\"gas\":null,\"value\":null," +
                "\"data\":\"0x0e89341c0000000000000000000000000000000000000000000000000000000000002625\"," +
                "\"nonce\":null,\"storageLimit\":null}],\"id\":0}]";

        data = "[{\"jsonrpc\":\"2.0\",\"method\":\"cfx_call\",\"params\":[{\"from\":null,\"to\":\"cfx:acc370g3s6d56ndcp8t6gyc657rhtp0fz6ytc8j9d2\"," +
                "\"gasPrice\":null,\"gas\":null,\"value\":null," +
                "\"data\":\"0x0e89341c0000000000000000000000000000000000000000000000000000000000002625\"," +
                "\"nonce\":null,\"storageLimit\":null}],\"id\":7}]";


        List<ConfluxRpcRequest> requestList = new ArrayList<>();
        Call call = new Call();
        call.setData("0x0e89341c0000000000000000000000000000000000000000000000000000000000002625");
        call.setTo("cfx:acc370g3s6d56ndcp8t6gyc657rhtp0fz6ytc8j9d2");
        ConfluxRpcRequest confluxRpcRequest = new ConfluxRpcRequest("cfx_call", call);
        requestList.add(confluxRpcRequest);

//        System.out.println(data);
        String s = JSONObject.toJSONString(requestList);
//        System.out.println(s);

//        String content = sendPost("http://main.confluxrpc.com", requestList);

        String content = sendPost("http://main.confluxrpc.com", data);
        System.out.println(content);

//        List<NftRpcResponse> nftRpcResponseList = JSONObject.parseArray(content, NftRpcResponse.class);
//        System.out.println(nftRpcResponseList);


    }

    public static String bean2Json(Object info) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(info);
        return jsonBody;
    }

    public static String sendPost(String url, String jsonBody)
            throws IOException {
        for (int i = 0; i < 299; i++) {
            final int j = i;
            new Thread(() -> {
                HttpPost httpPost = new HttpPost("http://www.baidu.com");
                httpPost.setHeader("Content-type", "application/json");
                CloseableHttpResponse execute = null;
                try {
                    execute = httpClient.execute(httpPost);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    String body = getBody(httpPost, execute);
                    System.out.println(j +"body");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

//        String jsonBody = bean2Json(object);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
//        ContentType.create("application/json", "utf-8")

        StringEntity entity = new StringEntity(jsonBody, ContentType.create("application/json", "utf-8"));
        entity.setContentEncoding(new BasicHeader("Content-Type", "application/json"));

        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CloseableHttpResponse response = httpClient.execute(httpPost);
        return getBody(httpPost, response);
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

}
