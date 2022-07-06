package com.fuxk.quickstart;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class LocalProviders {

    public static void main(String[] args) {
        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));
        try {
            EthAccounts ethAccounts = web3j.ethAccounts().sendAsync().get();
            List<String> accounts = ethAccounts.getAccounts();
            for (String account : accounts) {
                EthGetBalance ethGetBalance = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).sendAsync().get();
                System.out.println(account + " balance is " + ethGetBalance.getBalance());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
