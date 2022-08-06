package com.fuxk.tx.event;

import com.fuxk.tx.response.ApprovalEventResponse;
import com.fuxk.tx.response.TransferEventResponse;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ErcEvent {


    public static final Event APPROVAL_EVENT = new Event("Approval",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));


    public static ApprovalEventResponse getApprovalEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVAL_EVENT, log);
        ApprovalEventResponse response = new ApprovalEventResponse();
        response.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        response.spender = (String) eventValues.getIndexedValues().get(1).getValue();
        response.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


    public static TransferEventResponse getTransferEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(TRANSFER_EVENT, log);
        TransferEventResponse response = new TransferEventResponse();
        response.from = (String) eventValues.getIndexedValues().get(0).getValue();
        response.to = (String) eventValues.getIndexedValues().get(1).getValue();
        response.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


}
