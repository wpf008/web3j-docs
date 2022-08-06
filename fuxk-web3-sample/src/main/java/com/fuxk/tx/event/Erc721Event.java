package com.fuxk.tx.event;

import com.fuxk.tx.response.ApprovalEventResponse;
import com.fuxk.tx.response.ApprovalForAllEventResponse;
import com.fuxk.tx.response.TransferEventResponse;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;
import java.util.Arrays;


public class Erc721Event {


    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>(true) {
            }));

    public static final Event APPROVAL_EVENT = new Event("Approval",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>(true) {
            }));

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Bool>() {
            }));


    public TransferEventResponse getTransferEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(TRANSFER_EVENT, log);
        TransferEventResponse response = new TransferEventResponse();
        response.from = (String) eventValues.getIndexedValues().get(0).getValue();
        response.to = (String) eventValues.getIndexedValues().get(1).getValue();
        response.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        return response;
    }


    public ApprovalEventResponse getApprovalEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVAL_EVENT, log);
        ApprovalEventResponse response = new ApprovalEventResponse();
        response.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        response.approved = (String) eventValues.getIndexedValues().get(1).getValue();
        response.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        return response;
    }


    public ApprovalForAllEventResponse getApprovalForAllEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVALFORALL_EVENT, log);
        ApprovalForAllEventResponse response = new ApprovalForAllEventResponse();
        response.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        response.operator = (String) eventValues.getIndexedValues().get(1).getValue();
        response.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


}
