package com.fuxk.tx.response;


import lombok.Data;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;

@Data
public class OrdersMatchedEventResponse {

    public String maker;

    public String taker;

    public byte[] metadata;

    public byte[] buyHash;

    public byte[] sellHash;

    public BigInteger price;
}
