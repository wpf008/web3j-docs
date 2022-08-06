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
import java.util.List;

public class NftCreateEvent  {


    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));

    public static final Event SIGNERUPDATED_EVENT = new Event("SignerUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));

    public static final Event TRANSFERBATCH_EVENT = new Event("TransferBatch", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));

    public static final Event TRANSFERSINGLE_EVENT = new Event("TransferSingle", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));

    public static final Event URI_EVENT = new Event("URI", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>(true) {}));



    public static ApprovalForAllEventResponse getApprovalForAllEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(APPROVALFORALL_EVENT, log);
        ApprovalForAllEventResponse response = new ApprovalForAllEventResponse();
        response.setAccount((String) eventValues.getIndexedValues().get(0).getValue());
        response.setOperator((String) eventValues.getIndexedValues().get(1).getValue());
        response.setApproved((Boolean) eventValues.getNonIndexedValues().get(0).getValue());
        return response;
    }

    public static RoleAdminChangedEventResponse getRoleAdminChangedEvent(Log log) {
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


    public static RoleRevokedEventResponse getRoleRevokedEvent(Log log) {
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
