package com.fuxk.tx.event;

import com.fuxk.tx.response.*;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.protocol.core.methods.response.Log;

import java.util.Arrays;


public class Factory1155Event {

    public static final Event CREATENFT1155_EVENT = new Event("CreateNFT1155",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
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


    public CreateNFT1155EventResponse getCreateNFT1155Event(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(CREATENFT1155_EVENT, log);
        CreateNFT1155EventResponse response = new CreateNFT1155EventResponse();
        response.tokenAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
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


    public RoleGrantedEventResponse getRoleGrantedEvent(Log log) {
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

}
