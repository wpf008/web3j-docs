package com.fuxk.tx.response;

import lombok.Data;
import org.web3j.protocol.core.methods.response.Log;

import java.math.BigInteger;

@Data
public class BirthEventResponse {
    public Log log;

    public String owner;

    public BigInteger kittyId;

    public BigInteger matronId;

    public BigInteger sireId;

    public BigInteger genes;
}
