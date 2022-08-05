package com.fuxk.tx;

import lombok.Data;

import java.math.BigInteger;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/5 10:54
 */
@Data
public class MaticTransactionFlowRecord {

    private BigInteger time;
    private String from;
    private String to;
    private BigInteger value;
    private BigInteger gas;
    private BigInteger gasPrice;
    private BigInteger blockId;
    private String txhash;
    private String contractTo;
    private String contractFrom;
    private String contractAddress;
    private String contractValue;
    private String method;
    private String status;
    private String topic;


}
