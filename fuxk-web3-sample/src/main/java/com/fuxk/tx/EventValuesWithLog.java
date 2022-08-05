package com.fuxk.tx;

import org.web3j.abi.EventValues;
import org.web3j.abi.datatypes.Type;
import org.web3j.protocol.core.methods.response.Log;

import java.util.List;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/8/5 16:44
 */
public  class EventValuesWithLog {
    private final EventValues eventValues;
    private final Log log;

    public EventValuesWithLog(EventValues eventValues, Log log) {
        this.eventValues = eventValues;
        this.log = log;
    }

    public List<Type> getIndexedValues() {
        return this.eventValues.getIndexedValues();
    }

    public List<Type> getNonIndexedValues() {
        return this.eventValues.getNonIndexedValues();
    }

    public Log getLog() {
        return this.log;
    }
}
