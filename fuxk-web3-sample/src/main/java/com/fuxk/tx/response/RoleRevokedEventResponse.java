package com.fuxk.tx.response;

import lombok.Data;

@Data
public class RoleRevokedEventResponse {

    public byte[] role;

    public String account;

    public String sender;
}
