package com.fuxk.quickstart.payment;

import lombok.Data;

@Data
public class TransactionByHash {
    private String gas;
    private String gasPrice;
    private String maxFeePerGas;
    //交易记录中的maxPriorityFeePerGas
    private String maxPriorityFeePerGas;
    private String blockNumber;
}