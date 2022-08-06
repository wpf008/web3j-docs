package com.fuxk.tx.response;

import lombok.Data;
import org.web3j.protocol.core.methods.response.Log;

@Data
public class BaseURIUpdatedEventResponse {

    public Log log;

    public String uri;
}
