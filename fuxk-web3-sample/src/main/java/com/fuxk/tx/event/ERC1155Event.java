package com.fuxk.tx.event;

import com.fuxk.tx.response.*;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ERC1155Event {

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Bool>() {
            }));

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));

    public static final Event TRANSFERBATCH_EVENT = new Event("TransferBatch",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<DynamicArray<Uint256>>() {
            }, new TypeReference<DynamicArray<Uint256>>() {
            }));

    public static final Event TRANSFERSINGLE_EVENT = new Event("TransferSingle",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event URI_EVENT = new Event("URI",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
            }, new TypeReference<Uint256>(true) {
            }));


    public static ApprovalForAllEventResponse getApprovalForAllEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVALFORALL_EVENT, log);
        ApprovalForAllEventResponse response = new ApprovalForAllEventResponse();
        response.setAccount((String) eventValues.getIndexedValues().get(0).getValue());
        response.setOperator((String) eventValues.getIndexedValues().get(1).getValue());
        response.setApproved((Boolean) eventValues.getNonIndexedValues().get(0).getValue());
        return response;
    }


    public static OwnershipTransferredEventResponse getOwnershipTransferredEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse responses = new OwnershipTransferredEventResponse();
        responses.setPreviousOwner((String) eventValues.getIndexedValues().get(0).getValue());
        responses.setNewOwner((String) eventValues.getIndexedValues().get(1).getValue());
        return responses;
    }


    public static TransferBatchEventResponse getTransferBatchEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(TRANSFERBATCH_EVENT, log);
        TransferBatchEventResponse response = new TransferBatchEventResponse();
        response.setOperator((String) eventValues.getIndexedValues().get(0).getValue());
        response.setFrom((String) eventValues.getIndexedValues().get(1).getValue());
        response.setTo((String) eventValues.getIndexedValues().get(2).getValue());
        response.setIds((List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue());
        response.setValues((List<BigInteger>) eventValues.getNonIndexedValues().get(1).getValue());
        return response;
    }


    public static TransferSingleEventResponse getTransferSingleEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(TRANSFERSINGLE_EVENT, log);
        TransferSingleEventResponse response = new TransferSingleEventResponse();
        response.setOperator((String) eventValues.getIndexedValues().get(0).getValue());
        response.setFrom((String) eventValues.getIndexedValues().get(1).getValue());
        response.setTo((String) eventValues.getIndexedValues().get(2).getValue());
        response.setId((BigInteger) eventValues.getNonIndexedValues().get(0).getValue());
        response.setValue((BigInteger) eventValues.getNonIndexedValues().get(1).getValue());
        return response;
    }


    public static URIEventResponse getURIEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(URI_EVENT, log);
        URIEventResponse response = new URIEventResponse();
        response.setId((BigInteger) eventValues.getIndexedValues().get(0).getValue());
        response.setValue((String) eventValues.getNonIndexedValues().get(0).getValue());
        return response;
    }
}
