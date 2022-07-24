package com.fuxk.quickstart.nft;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashKey {

    private final static String contractAddress = "0xeF97e78608819E162C5F9CCd9bb585A58b41515E";

    private final static String address = "0x94d85100b768b112f56fc1197fc8a535e28aeb5f";

    private static Web3j web3j = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));

    public static void main(String[] args) {
        try {
            Function function = new Function("tokensOfOwner",
                    Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(address)),
                    Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {
                    }));
            String data = FunctionEncoder.encode(function);
            org.web3j.protocol.core.methods.request.Transaction transaction =
                    new org.web3j.protocol.core.methods.request.Transaction(null, null, null, null,
                            contractAddress, null, data);
            EthCall ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).sendAsync().get();
            List<Type> dd = new ArrayList<>();
            if (ethCall != null) {
                String value = ethCall.getValue();
                List<Type> values = FunctionReturnDecoder.decode(value, function.getOutputParameters());
                if (!values.isEmpty()) {
                    dd = (List<Type>) values.get(0).getValue();
                }
            }
            for (Type a : dd) {
                BigInteger tokenId = (BigInteger) a.getValue();
                String tokenUri = getTokenUri(contractAddress, tokenId);
                System.out.println(tokenUri);
            }
        } catch (Exception e) {
        }finally {

            web3j.shutdown();
            System.out.println("shutdown");
        }
    }

    private static String getTokenUri(String contractAddress, BigInteger tokenId) {
        Function function = new Function("uri",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Uint(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }));
        String data = FunctionEncoder.encode(function);
        org.web3j.protocol.core.methods.request.Transaction transaction =
                new org.web3j.protocol.core.methods.request.Transaction(null, null, null, null,
                        contractAddress, null, data);
        try {
            EthCall ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).sendAsync().get();
            if (ethCall != null) {
                String value = ethCall.getValue();
                List<Type> values = FunctionReturnDecoder.decode(value, function.getOutputParameters());
                if (!values.isEmpty()) {
                    return values.get(0).getValue().toString();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
