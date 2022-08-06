package com.fuxk.tx.event;

import com.fuxk.tx.response.*;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;
import java.util.Arrays;

public class WyvernExchangeContractEvent {

    public static final Event ORDERAPPROVEDPARTONE_EVENT = new Event("OrderApprovedPartOne",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Address>() {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint8>() {
            }, new TypeReference<Uint8>() {
            }, new TypeReference<Uint8>() {
            }, new TypeReference<Address>() {
            }));

    public static final Event ORDERAPPROVEDPARTTWO_EVENT = new Event("OrderApprovedPartTwo",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }, new TypeReference<Uint8>() {
            }, new TypeReference<DynamicBytes>() {
            }, new TypeReference<DynamicBytes>() {
            }, new TypeReference<Address>() {
            }, new TypeReference<DynamicBytes>() {
            }, new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Bool>() {
            }));

    public static final Event ORDERCANCELLED_EVENT = new Event("OrderCancelled",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {
            }));

    public static final Event ORDERSMATCHED_EVENT = new Event("OrdersMatched",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {
            }, new TypeReference<Bytes32>() {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }, new TypeReference<Bytes32>(true) {
            }));

    public static final Event NONCEINCREMENTED_EVENT = new Event("NonceIncremented",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event OWNERSHIPRENOUNCED_EVENT = new Event("OwnershipRenounced",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }));

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));

    public OrderApprovedPartOneEventResponse getOrderApprovedPartOneEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ORDERAPPROVEDPARTONE_EVENT, log);
        OrderApprovedPartOneEventResponse response = new OrderApprovedPartOneEventResponse();
        response.hash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        response.maker = (String) eventValues.getIndexedValues().get(1).getValue();
        response.feeRecipient = (String) eventValues.getIndexedValues().get(2).getValue();
        response.exchange = (String) eventValues.getNonIndexedValues().get(0).getValue();
        response.taker = (String) eventValues.getNonIndexedValues().get(1).getValue();
        response.makerRelayerFee = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        response.takerRelayerFee = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        response.makerProtocolFee = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        response.takerProtocolFee = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
        response.feeMethod = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
        response.side = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
        response.saleKind = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
        response.target = (String) eventValues.getNonIndexedValues().get(9).getValue();
        return response;
    }


    public OrderApprovedPartTwoEventResponse getOrderApprovedPartTwoEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ORDERAPPROVEDPARTTWO_EVENT, log);
        OrderApprovedPartTwoEventResponse response = new OrderApprovedPartTwoEventResponse();
        response.hash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        response.howToCall = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        response.calldata = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
        response.replacementPattern = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
        response.staticTarget = (String) eventValues.getNonIndexedValues().get(3).getValue();
        response.staticExtradata = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
        response.paymentToken = (String) eventValues.getNonIndexedValues().get(5).getValue();
        response.basePrice = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
        response.extra = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
        response.listingTime = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
        response.expirationTime = (BigInteger) eventValues.getNonIndexedValues().get(9).getValue();
        response.salt = (BigInteger) eventValues.getNonIndexedValues().get(10).getValue();
        response.orderbookInclusionDesired = (Boolean) eventValues.getNonIndexedValues().get(11).getValue();
        return response;
    }


    public OrderCancelledEventResponse getOrderCancelledEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ORDERCANCELLED_EVENT, log);
        OrderCancelledEventResponse response = new OrderCancelledEventResponse();
        response.hash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        return response;
    }


    public OrdersMatchedEventResponse getOrdersMatchedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ORDERSMATCHED_EVENT, log);
        OrdersMatchedEventResponse response = new OrdersMatchedEventResponse();
        response.maker = (String) eventValues.getIndexedValues().get(0).getValue();
        response.taker = (String) eventValues.getIndexedValues().get(1).getValue();
        response.metadata = (byte[]) eventValues.getIndexedValues().get(2).getValue();
        response.buyHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
        response.sellHash = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
        response.price = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return response;
    }


    public NonceIncrementedEventResponse getNonceIncrementedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(NONCEINCREMENTED_EVENT, log);
        NonceIncrementedEventResponse response = new NonceIncrementedEventResponse();
        response.maker = (String) eventValues.getIndexedValues().get(0).getValue();
        response.newNonce = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


    public OwnershipRenouncedEventResponse getOwnershipRenouncedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(OWNERSHIPRENOUNCED_EVENT, log);
        OwnershipRenouncedEventResponse response = new OwnershipRenouncedEventResponse();
        response.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        return response;
    }


    public OwnershipTransferredEventResponse getOwnershipTransferredEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse response = new OwnershipTransferredEventResponse();
        response.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        response.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
        return response;
    }

}
