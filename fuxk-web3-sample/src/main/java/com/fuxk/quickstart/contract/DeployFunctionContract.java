package com.fuxk.quickstart.contract;

import com.fuxk.quickstart.LocalProviders;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class DeployFunctionContract {

    private static Web3j web3j = LocalProviders.buildWeb3j();

    public static void main(String[] args) throws Exception {
        Web3j web3j = LocalProviders.buildWeb3j();
        Credentials credentials = Credentials.create("0911c1487d495343dcd16c4909ef2d38009e87087218dcb504255a5e11dff899");
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
        Function contract = Function.load("0x4a97042102E1F86c17f53f6B6Ff0F6802F2Fb2b2",web3j,credentials,
                new StaticGasProvider(gasPrice,BigInteger.valueOf(3000000L)));
        BigInteger value = contract.add(BigInteger.TEN, BigInteger.TEN).send().getValue();
        System.out.printf(value.toString());
//        String deploy = deploy();
    }

    private static String deploy() throws Exception {
        Credentials credentials = Credentials.create("0911c1487d495343dcd16c4909ef2d38009e87087218dcb504255a5e11dff899");
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
        Function function = Function.deploy(web3j, credentials, new StaticGasProvider(gasPrice, BigInteger.valueOf(3000000L))).send();
        System.out.printf(function.getContractAddress());
        return function.getContractAddress();
    }


}
