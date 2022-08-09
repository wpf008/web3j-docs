package com.fuxk.tx.response;

import lombok.Data;
import org.web3j.abi.datatypes.generated.Uint256;

import java.math.BigInteger;
import java.util.List;

@Data
public class TransferBatchEventResponse {
    public String operator;

    public String from;

    public String to;

    public List<Uint256> ids;

    public List<Uint256> values;
}
