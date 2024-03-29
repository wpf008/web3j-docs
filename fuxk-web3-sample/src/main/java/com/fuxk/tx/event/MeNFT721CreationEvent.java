package com.fuxk.tx.event;

import com.fuxk.tx.response.*;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;
import java.util.Arrays;


public class MeNFT721CreationEvent {

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

    public static final Event BASEURIUPDATED_EVENT = new Event("BaseURIUpdated",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
            }));

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Bytes32>(true) {
            }, new TypeReference<Bytes32>(true) {
            }));

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));

    public static final Event SIGNERUPDATED_EVENT = new Event("SignerUpdated",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }));

    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>(true) {
            }));


    public static ApprovalEventResponse getApprovalEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVAL_EVENT, log);
        ApprovalEventResponse response = new ApprovalEventResponse();
        response.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
        response.approved = (String) eventValues.getNonIndexedValues().get(1).getValue();
        response.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return response;
    }

    public static ApprovalForAllEventResponse getApprovalForAllEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVALFORALL_EVENT, log);
        ApprovalForAllEventResponse response = new ApprovalForAllEventResponse();
        response.setAccount((String) eventValues.getIndexedValues().get(0).getValue());
        response.setOperator((String) eventValues.getIndexedValues().get(1).getValue());
        response.setApproved((Boolean) eventValues.getNonIndexedValues().get(0).getValue());
        return response;
    }


    public static BaseURIUpdatedEventResponse getBaseURIUpdatedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(BASEURIUPDATED_EVENT, log);
        BaseURIUpdatedEventResponse response = new BaseURIUpdatedEventResponse();
        response.uri = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


    public RoleAdminChangedEventResponse getRoleAdminChangedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ROLEADMINCHANGED_EVENT, log);
        RoleAdminChangedEventResponse response = new RoleAdminChangedEventResponse();
        response.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        response.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
        response.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
        return response;
    }


    public static RoleGrantedEventResponse getRoleGrantedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ROLEGRANTED_EVENT, log);
        RoleGrantedEventResponse response = new RoleGrantedEventResponse();
        response.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        response.account = (String) eventValues.getIndexedValues().get(1).getValue();
        response.sender = (String) eventValues.getIndexedValues().get(2).getValue();
        return response;
    }


    public RoleRevokedEventResponse getRoleRevokedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ROLEREVOKED_EVENT, log);
        RoleRevokedEventResponse response = new RoleRevokedEventResponse();
        response.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        response.account = (String) eventValues.getIndexedValues().get(1).getValue();
        response.sender = (String) eventValues.getIndexedValues().get(2).getValue();
        return response;
    }


    public SignerUpdatedEventResponse getSignerUpdatedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(SIGNERUPDATED_EVENT, log);
        SignerUpdatedEventResponse response = new SignerUpdatedEventResponse();
        response.newSigner = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


    public static TransferEventResponse getTransferEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(TRANSFER_EVENT, log);
        TransferEventResponse response = new TransferEventResponse();
        response.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
        response.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
        response.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return response;
    }
}
