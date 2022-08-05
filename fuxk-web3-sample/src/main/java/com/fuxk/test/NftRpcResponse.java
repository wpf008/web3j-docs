package com.fuxk.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/4 16:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NftRpcResponse {

    private String result;

    private Integer id;

}
