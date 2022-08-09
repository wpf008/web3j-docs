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
import java.util.List;

public class AllEvent {

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
    public static final Event BASEURIUPDATED_EVENT = new Event("BaseURIUpdated",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
            }));

    public static final Event MIGRATE_EVENT = new Event("Migrate",
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
            }, new TypeReference<Utf8String>() {
            }));


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


    public static OrderApprovedPartOneEventResponse getOrderApprovedPartOneEvent(Log log) {
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


    public static OrderApprovedPartTwoEventResponse getOrderApprovedPartTwoEvent(Log log) {
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


    public static OrderCancelledEventResponse getOrderCancelledEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(ORDERCANCELLED_EVENT, log);
        OrderCancelledEventResponse response = new OrderCancelledEventResponse();
        response.hash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        return response;
    }


    public static OrdersMatchedEventResponse getOrdersMatchedEvent(Log log) {
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


    public  static NonceIncrementedEventResponse getNonceIncrementedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(NONCEINCREMENTED_EVENT, log);
        NonceIncrementedEventResponse response = new NonceIncrementedEventResponse();
        response.maker = (String) eventValues.getIndexedValues().get(0).getValue();
        response.newNonce = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


    public static OwnershipRenouncedEventResponse getOwnershipRenouncedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(OWNERSHIPRENOUNCED_EVENT, log);
        OwnershipRenouncedEventResponse response = new OwnershipRenouncedEventResponse();
        response.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        return response;
    }


    public static MigrateEventResponse getMigrateEvents(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(MIGRATE_EVENT, log);
        MigrateEventResponse response = new MigrateEventResponse();
        response.snapshot_tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        response.uri = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return response;
    }


    public static BaseURIUpdatedEventResponse getBaseURIUpdatedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(BASEURIUPDATED_EVENT, log);
        BaseURIUpdatedEventResponse response = new BaseURIUpdatedEventResponse();
        response.uri = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return response;
    }


    public static CreateNFT1155EventResponse getCreateNFT1155Event(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(CREATENFT1155_EVENT, log);
        CreateNFT1155EventResponse response = new CreateNFT1155EventResponse();
        response.tokenAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
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


    public static SignerUpdatedEventResponse getSignerUpdatedEvent(Log log) {
        EventValues eventValues = BaseEvent.staticExtractEventParameters(SIGNERUPDATED_EVENT, log);
        SignerUpdatedEventResponse response = new SignerUpdatedEventResponse();
        response.newSigner = (String) eventValues.getNonIndexedValues().get(0).getValue();
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
        response.setIds((List<Uint256>) eventValues.getNonIndexedValues().get(0).getValue());
        response.setValues((List<Uint256>) eventValues.getNonIndexedValues().get(1).getValue());
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
