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
    private BigInteger gas;
    private BigInteger gasPrice;
    private BigInteger blockId;
    private String txHash;
    private BigInteger value;
    private String contractTo;
    private String contractValue;
    private String contractAmount;
    private String contractFrom;
    private String contractAddress;
    private String method;
    private String status;
    private String topic;
}
