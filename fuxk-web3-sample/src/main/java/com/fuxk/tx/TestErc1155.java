package com.fuxk.tx;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/5 16:10
 */
public class TestErc1155 {

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

    public static void main(String[] args) throws IOException {
        TransactionReceipt transactionReceipt = polygon
                .ethGetTransactionReceipt("0x56f1550e5bd19913de4b4d369226f4b84f152bdf454964d45f3f45b61a4cde95")
                .send().getResult();


        List<Log> logs = transactionReceipt.getLogs();
        for (Log log : logs) {
            List<String> topics = log.getTopics();
            if (topics.size() > 0) {
                String topic = topics.get(0);
                if (transfer_batch_topic.equals(topic)) {
                    EventValues eventValues = staticExtractEventParameters(Erc1155.TRANSFERBATCH_EVENT, log);
                    Erc1155.TransferBatchEventResponse typedResponse = new Erc1155.TransferBatchEventResponse();
                    typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                    typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
                    typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
                    System.out.println(typedResponse);
                }
            }
        }


//        List<EventValuesWithLog> eventValuesWithLogs = extractEventParametersWithLog(Erc1155.TRANSFERBATCH_EVENT, transactionReceipt);
//        ArrayList<Erc1155.TransferBatchEventResponse> responses = new ArrayList<Erc1155.TransferBatchEventResponse>(eventValuesWithLogs.size());
//        for (EventValuesWithLog eventValues : eventValuesWithLogs) {
//            Erc1155.TransferBatchEventResponse typedResponse = new Erc1155.TransferBatchEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
//            typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
//            typedResponse.ids = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
//            typedResponse.values = (List<BigInteger>) eventValues.getNonIndexedValues().get(1).getValue();
//            responses.add(typedResponse);
//        }
//        for (Erc1155.TransferBatchEventResponse respons : responses) {
//            System.out.println(respons);
//        }
    }


    public static EventValues staticExtractEventParameters(Event event, Log log) {
        List<String> topics = log.getTopics();
        String encodedEventSignature = EventEncoder.encode(event);
        if (topics != null && topics.size() != 0 && ((String) topics.get(0)).equals(encodedEventSignature)) {
            List<Type> indexedValues = new ArrayList();
            List<Type> nonIndexedValues = FunctionReturnDecoder.decode(log.getData(), event.getNonIndexedParameters());
            List<TypeReference<Type>> indexedParameters = event.getIndexedParameters();
            for (int i = 0; i < indexedParameters.size(); ++i) {
                Type value = FunctionReturnDecoder.decodeIndexedValue((String) topics.get(i + 1), (TypeReference) indexedParameters.get(i));
                indexedValues.add(value);
            }
            return new EventValues(indexedValues, nonIndexedValues);
        } else {
            return null;
        }
    }

}
