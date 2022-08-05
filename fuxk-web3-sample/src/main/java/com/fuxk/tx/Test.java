package com.fuxk.tx;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/5 10:15
 */
public class Test {
    private static Web3j polygon = Web3j.build(new HttpService("https://polygon-mainnet.g.alchemy.com/v2/5wBExrqWaXi-ktSY6m9a3uvx3lBgF6iG"));

    private final static String transfer_topic = "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef";
    private final static String transfer_single_topic = "0xc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62";
    private final static String transfer_batch_topic = "0x4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb";
    private final static String create_token1155_topic = "0x6410302e5af9832a2ca52c75190a9a1608e6c421318e2ccfdc2155cea0b8a776";
    private final static String create_token721_topic = "0xb0ad49f5fccbda349c989415533bf1591adb3f35bf7db78344d5140399dcd60a";
    private final static String migrate_topic = "0x8c8817f351212fdf5d8f3b5b4e051173792e8a2acc4607bfdda13566ee5c1f2c";
    private final static String approval_topic = "0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925";
    private final static String role_granted_topic = "0x2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d";
    private final static String rarible_match_order_topic = "0x268820db288a211986b26a8fda86b1e0046281b21206936bb0e61c67b5c79ef4";
    private final static String matic_topic = "0x4dfe1bbbcf077ddc3e01291eea2d5c70c2b422b415d95645b9adcfd678cb1d63";


    public static void main(String[] args) {
        try {
            BigInteger blockNumber = polygon.ethBlockNumber().send().getBlockNumber();//获取当前区块

            blockNumber = BigInteger.valueOf(31533747L);
            BigInteger transactionCount = polygon.ethGetBlockTransactionCountByNumber(DefaultBlockParameter.valueOf(blockNumber)).send().getTransactionCount(); //获取当前区块的数量
            System.out.println("blockNumber is :" + blockNumber);
            System.out.println("transactionCount is: " + transactionCount);
            insertion(blockNumber, transactionCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertion(BigInteger blockNumber, BigInteger transactionCount) {
        try {
            BigInteger timestamp = polygon.ethGetBlockByNumber(DefaultBlockParameter.valueOf(blockNumber), true).send().getBlock().getTimestamp();
            for (int i = 0; i < transactionCount.intValue(); i++) {
                Transaction transaction = polygon.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(blockNumber), BigInteger.valueOf(i)).send().getTransaction().get();
                MaticTransactionFlowRecord maticTransactionFlowRecord = new MaticTransactionFlowRecord();
                maticTransactionFlowRecord.setTime(timestamp);
                maticTransactionFlowRecord.setBlockId(blockNumber);
                maticTransactionFlowRecord.setFrom(transaction.getFrom().toLowerCase());
                maticTransactionFlowRecord.setTo(transaction.getTo().toLowerCase());
                maticTransactionFlowRecord.setGasPrice(transaction.getGasPrice());
                maticTransactionFlowRecord.setTxhash(transaction.getHash());
                maticTransactionFlowRecord.setValue(transaction.getValue());
                System.out.println(maticTransactionFlowRecord);
                String methodId = "0x";
                BigInteger value = transaction.getValue();
                String input = transaction.getInput();
                if (input != null && input.length() > 10)
                    methodId = input.substring(0, 10);
                TransactionReceipt transactionReceipt = polygon.ethGetTransactionReceipt(transaction.getHash()).send().getResult();
                String status = transactionReceipt.getStatus();
                maticTransactionFlowRecord.setStatus(status);
                maticTransactionFlowRecord.setGas(transactionReceipt.getGasUsed());
                String contractTo = "";
                String contractFrom = "";
                String contractValue = "";
                String contractAddress = "";
                String method = "";
                if ("0".equals(status)) {//交易失败
                    maticTransactionFlowRecord.setMethod("Transfer");
                } else {
                    List<Log> logs = transactionReceipt.getLogs();

                    if (logs != null && logs.size() > 0) { //todo 判空
                        if ("0x".equals(input) && !value.equals(BigInteger.ZERO)) {
                            maticTransactionFlowRecord.setContractAddress("");
                            maticTransactionFlowRecord.setMethod("Transfer");
                        }
                        for (Log log : logs) {
                            contractAddress = log.getAddress().toLowerCase();
                            method = "Contract Interaction";
                            List<String> topics = log.getTopics();
                            if (topics.size() > 0) {
                                String topic = topics.get(0);
                                if (transfer_single_topic.equals(topic)) {
                                }
                            }
                        }
                    }


                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}