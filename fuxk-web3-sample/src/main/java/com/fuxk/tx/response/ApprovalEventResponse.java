package com.fuxk.tx.response;

import lombok.Data;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;

@Data
public class ApprovalEventResponse {
    public Log log;

    public String owner;

    public String approved;

    public BigInteger tokenId;


    public String spender;

    public BigInteger value;

}
