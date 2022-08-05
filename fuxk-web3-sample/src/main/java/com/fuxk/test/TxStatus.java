package com.fuxk.test;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutionException;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/3 10:48
 */
public class TxStatus {

    public static void main(String[] args) {
//        Web3j polygon = Web3j.build(new HttpService("https://polygon-rpc.com/"));

        Web3j polygon = Web3j.build(new HttpService("https://polygon-mainnet.g.alchemy.com/v2/5wBExrqWaXi-ktSY6m9a3uvx3lBgF6iG"));


//
//        EthGetTransactionReceipt send = null;
//        try {
//            send = polygon.ethGetTransactionReceipt("0xf2382277edf8b7a338b0c8665bdf8a1447cbdc5c093ff25f7c515d16a0c516ae").sendAsync().get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        TransactionReceipt result = send.getResult();
//        String status = result.getStatus();
//
//        System.out.println(status);

        System.out.println("https://polygon-mainnet.g.alchemy.com/v2/5wBExrqWaXi-ktSY6m9a3uvx3lBgF6iG".length());
    }
}
