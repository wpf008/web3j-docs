package com.fuxk.tx.response;

import lombok.Data;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;

@Data
public class NonceIncrementedEventResponse {

    public String maker;

    public BigInteger newNonce;
}
