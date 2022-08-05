package com.fuxk.test;

import lombok.Data;

import java.util.List;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/2 18:20
 */

@Data
public class JsonRpcRequest<S> {

    private long id = 1;
    private String jsonrpc = "2.0";
    private String method;
    private List<S> params;
}
