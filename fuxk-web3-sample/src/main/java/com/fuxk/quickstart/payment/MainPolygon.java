package com.fuxk.quickstart.payment;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/7/29 17:37
 */
public class MainPolygon {

    private static String polygonUrl = "https://polygon-rpc.com/";

    private static Web3j polygonWeb3j = Web3j.build(new HttpService(polygonUrl));

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        EthGetTransactionCount transactionCount = polygonWeb3j.ethGetTransactionCount("0xad6b81c6ce0833a30d381561d7e7b1801f2f66e8",
                DefaultBlockParameterName.LATEST).sendAsync().get(2, TimeUnit.MINUTES);
        BigInteger nonce = transactionCount.getTransactionCount();
        System.out.println(nonce);

    }
}
