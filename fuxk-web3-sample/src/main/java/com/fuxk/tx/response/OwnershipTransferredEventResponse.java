package com.fuxk.tx.response;

import lombok.Data;

@Data
public class OwnershipTransferredEventResponse {

    public String previousOwner;

    public String newOwner;
}
