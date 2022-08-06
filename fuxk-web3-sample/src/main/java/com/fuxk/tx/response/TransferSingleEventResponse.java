package com.fuxk.tx.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class TransferSingleEventResponse {

    public String operator;

    public String from;

    public String to;

    public BigInteger id;

    public BigInteger value;
}
