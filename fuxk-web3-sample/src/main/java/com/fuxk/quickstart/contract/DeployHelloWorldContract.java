package com.fuxk.quickstart.contract;

import com.fuxk.quickstart.LocalProviders;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;

public class DeployHelloWorldContract {

   private static Web3j web3j = LocalProviders.buildWeb3j();


    // GAS价格
    public static BigInteger GAS_PRICE = BigInteger.valueOf(2000_000_000L);
    // GAS上限
    public static BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000L);
    // 交易费用
    public static BigInteger GAS_VALUE = BigInteger.valueOf(100_000L);;

    public static void main(String[] args) throws Exception {
        name();
    }


    //调用方法
    private static  void name() throws Exception {
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
        Credentials credentials = Credentials.create("0911c1487d495343dcd16c4909ef2d38009e87087218dcb504255a5e11dff899");
        Helloworld helloworld = Helloworld.load("0xDABff63A013DDBA511c2CABF0aA1588a2F994C6F",web3j, credentials, new StaticGasProvider(gasPrice, BigInteger.valueOf(3000000L)));
        String value = helloworld._name().send().getValue();
        System.out.printf(value);
    }





    //部署合约
    private static String deploy() throws Exception {
        Credentials credentials = Credentials.create("0x677b03ad67f0e128bf6f9483513c64a22cfdab8926ffd2bc72dec8ee5e9bacc2");
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
        Helloworld helloworld = Helloworld.deploy(web3j, credentials, gasPrice, GAS_LIMIT).send();
        System.out.printf(helloworld.getContractAddress());
        return helloworld.getContractAddress();
    }


}
