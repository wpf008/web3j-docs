package com.fuxk.tx.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderApprovedPartTwoEventResponse {

    public byte[] hash;

    public BigInteger howToCall;

    public byte[] calldata;

    public byte[] replacementPattern;

    public String staticTarget;

    public byte[] staticExtradata;

    public String paymentToken;

    public BigInteger basePrice;

    public BigInteger extra;

    public BigInteger listingTime;

    public BigInteger expirationTime;

    public BigInteger salt;

    public Boolean orderbookInclusionDesired;
}
