package com.fuxk.tx.response;

import lombok.Data;

@Data
public class RoleAdminChangedEventResponse {

    public byte[] role;

    public byte[] previousAdminRole;

    public byte[] newAdminRole;
}
