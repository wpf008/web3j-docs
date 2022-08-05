package com.fuxk.tx;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthCompileSolidity;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.util.Map;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/5 11:49
 */
public class ABI {


    private static Web3j polygon = Web3j.build(new HttpService("https://polygon-mainnet.g.alchemy.com/v2/5wBExrqWaXi-ktSY6m9a3uvx3lBgF6iG"));


    public void abi() {
    }
}
