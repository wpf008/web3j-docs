package com.fuxk.tx.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class MigrateEventResponse {

    public BigInteger snapshot_tokenId;

    public String uri;
}
