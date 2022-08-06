package com.fuxk.tx.response;

import lombok.Data;

@Data
public class ApprovalForAllEventResponse {

    public String account;

    public String operator;

    public Boolean approved;

    public String owner;

}
