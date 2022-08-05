package com.fuxk.quickstart;

import io.reactivex.Observable;
import org.reactivestreams.Subscription;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class LocalProviders {



    public static Web3j buildWeb3j() {
        Web3j localWeb3j = Web3j.build(new HttpService("https://polygon-mainnet.g.alchemy.com/v2/5wBExrqWaXi-ktSY6m9a3uvx3lBgF6iG"));
        return localWeb3j;
    }



    public static void main(String[] args) throws IOException {
        Web3j web3j = buildWeb3j();

        String web3ClientVersion = web3j.web3ClientVersion().send().getWeb3ClientVersion();
        System.out.println(web3ClientVersion);
//        try {
//            EthAccounts ethAccounts = web3j.ethAccounts().sendAsync().get();
//            List<String> accounts = ethAccounts.getAccounts();
//            for (String account : accounts) {
//                EthGetBalance ethGetBalance = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).sendAsync().get();
//                System.out.println(account + " balance is " + ethGetBalance.getBalance());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
