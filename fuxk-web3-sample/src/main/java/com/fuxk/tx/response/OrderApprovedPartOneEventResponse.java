package com.fuxk.tx.response;

import lombok.Data;
import java.math.BigInteger;

@Data
public class OrderApprovedPartOneEventResponse {

    public byte[] hash;

    public String maker;

    public String feeRecipient;

    public String exchange;

    public String taker;

    public BigInteger makerRelayerFee;

    public BigInteger takerRelayerFee;

    public BigInteger makerProtocolFee;

    public BigInteger takerProtocolFee;

    public BigInteger feeMethod;

    public BigInteger side;

    public BigInteger saleKind;

    public String target;
}
