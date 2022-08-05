package com.fuxk.quickstart.payment;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MintBatchRequest mintBatchRequest = new MintBatchRequest();
        mintBatchRequest.setAddress("0x94d85100b768b112f56fc1197fc8a535e28aeb5f");
        //0x1808B75f329C9d6BD4784e2d4993c6a61D674544
        mintBatchRequest.setContractAddress("0x1808B75f329C9d6BD4784e2d4993c6a61D674544");//0x98f3c7406160d21cb66e8361e8dba251f1fdb003
        List<Integer> quantity = Arrays.asList(10);
        mintBatchRequest.setQuantity(quantity);
        mintBatchRequest.setSalt("xyz123");
        mintBatchRequest.setUuids(Arrays.asList("xyx"));
        mintBatchRequest.setNftId(55139);

        mintBatchRequest.setGasFactor(160);

//        mintBatchRequest.setNonce(435);
        CreateTokenService createTokenService = new CreateTokenService();
        NftTransactionRecord nftTransactionRecord = createTokenService.mintBatch1155Token(mintBatchRequest);
        System.out.println(nftTransactionRecord.getTxHash());
        System.out.println(nftTransactionRecord.getNonce().toString());
        System.out.println("nftTransactionRecord is " + nftTransactionRecord);
//
//        createTokenService.getNonce();
    }
}
