package com.fuxk.tx.response;

import lombok.Data;

@Data
public class OwnershipRenouncedEventResponse {

    public String previousOwner;


    public String newOwner;
}
