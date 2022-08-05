package com.fuxk.test;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/4 16:19
 */
@Data
public class ConfluxRpcRequest {
    private static AtomicLong nextId = new AtomicLong(0);

    private String jsonrpc = "2.0";
    private String method;
    private List<Object> params;
    private long id;

    public ConfluxRpcRequest() {

    }

    public ConfluxRpcRequest(String method, Object params) {
        this.method = method;
        this.params = Arrays.asList(params);
        this.id = nextId.getAndIncrement();
    }


}
