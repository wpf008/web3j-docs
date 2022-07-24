package com.fuxk.quickstart.payment;

import lombok.Data;

import java.util.List;

@Data
public class MintBatchRequest {
    private String contractAddress; //DefaultTokenAddress

    private String address;//用户地址

    private List<Integer> quantity;

    private String salt;


    private List<String> uuids;

    private Integer nftId;

    private Integer gasFactor = 1;

    private long nonce = -1;
}
