package com.fuxk.tx.event;

import com.fuxk.tx.response.ApprovalEventResponse;
import com.fuxk.tx.response.BirthEventResponse;
import com.fuxk.tx.response.ContractUpgradeEventResponse;
import com.fuxk.tx.response.TransferEventResponse;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;
import java.util.Arrays;


public class CKEvent {

    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }, new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event APPROVAL_EVENT = new Event("Approval",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }, new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event BIRTH_EVENT = new Event("Birth",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event CONTRACTUPGRADE_EVENT = new Event("ContractUpgrade",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }));


    public static TransferEventResponse getTransferEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(TRANSFER_EVENT, log);
        TransferEventResponse response = new TransferEventResponse();
        response.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
        response.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
        response.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return response;
    }


    public static ApprovalEventResponse getApprovalEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVAL_EVENT, log);
        ApprovalEventResponse response = new ApprovalEventResponse();
        response.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
        response.approved = (String) eventValues.getNonIndexedValues().get(1).getValue();
        response.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return response;
    }


    public static BirthEventResponse getBirthEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(BIRTH_EVENT, log);
        BirthEventResponse response = new BirthEventResponse();
        response.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
        response.kittyId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        response.matronId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        response.sireId = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        response.genes = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return response;
    }

    public static ContractUpgradeEventResponse getContractUpgradeEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(CONTRACTUPGRADE_EVENT, log);
        ContractUpgradeEventResponse response = new ContractUpgradeEventResponse();
        response.newContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }

}
