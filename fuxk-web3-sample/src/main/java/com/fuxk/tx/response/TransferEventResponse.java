package com.fuxk.tx.response;

import lombok.Data;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;

@Data
public class TransferEventResponse {
    public Log log;

    public String from;

    public String to;

    public BigInteger tokenId;

    public BigInteger value;


}
