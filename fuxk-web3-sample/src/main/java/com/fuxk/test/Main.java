package com.fuxk.test;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/2 18:14
 */
public class Main {

    private final static OkHttpClient txOkHttpClient;


    static {

        txOkHttpClient = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }


    public static void main(String[] args) throws IOException {
        JsonRpcRequest jsonRpcRequest = new JsonRpcRequest();
        List<Object> list = new ArrayList<>();
        list.add("0xd4462e2606190d8b912b509447667d88ea7ee033a627dde91a78db41bc9bfec4");
        list.add("0xd4462e2606190d8b912b509447667d88ea7ee033a627dde91a78db41bc9bfec4");
        jsonRpcRequest.setMethod("eth_getTransactionReceipt");
        jsonRpcRequest.setParams(list);
        String s = JSON.toJSONString(jsonRpcRequest);
        System.out.println(s);

        RequestBody body = RequestBody.create(
                s,MediaType.parse("application/json"));
//        RequestBody body = new FormBody.Builder()
//                .add("id", "1")
//                .add("method", "eth_getTransactionReceipt")
//                .add("params", JSON.toJSONString(list))
//                .add("jsonrpc", "2.0")
//                .build();
        Request request = new Request.Builder().post(body).url("https://polygon-rpc.com/").addHeader("Content-type", "application/json").build();
        Response response = txOkHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String result = response.body().string();
            System.out.println(result);
        }

    }
}
