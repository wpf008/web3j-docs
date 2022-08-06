package com.fuxk.tx.response;

import lombok.Data;

@Data
public class RoleGrantedEventResponse {

    public byte[] role;

    public String account;

    public String sender;
}
