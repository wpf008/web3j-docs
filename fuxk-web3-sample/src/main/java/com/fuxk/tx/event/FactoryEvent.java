package com.fuxk.tx.event;

import com.fuxk.tx.response.RoleAdminChangedEventResponse;
import com.fuxk.tx.response.RoleGrantedEventResponse;
import com.fuxk.tx.response.RoleRevokedEventResponse;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.protocol.core.methods.response.Log;

import java.util.Arrays;


public class FactoryEvent {


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


}
