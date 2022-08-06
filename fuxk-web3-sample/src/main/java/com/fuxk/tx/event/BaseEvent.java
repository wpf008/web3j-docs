package com.fuxk.tx.event;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.protocol.core.methods.response.Log;

import java.util.ArrayList;
import java.util.List;

public class BaseEvent {

    public static EventValues staticExtractEventParameters(Event event, Log log) {
        List<String> topics = log.getTopics();
        String encodedEventSignature = EventEncoder.encode(event);
        if (topics != null && topics.size() != 0 && ((String) topics.get(0)).equals(encodedEventSignature)) {
            List<Type> indexedValues = new ArrayList();
            List<Type> nonIndexedValues = FunctionReturnDecoder.decode(log.getData(), event.getNonIndexedParameters());
            List<TypeReference<Type>> indexedParameters = event.getIndexedParameters();
            for (int i = 0; i < indexedParameters.size(); ++i) {
                Type value = FunctionReturnDecoder.decodeIndexedValue((String) topics.get(i + 1), (TypeReference) indexedParameters.get(i));
                indexedValues.add(value);
            }
            return new EventValues(indexedValues, nonIndexedValues);
        } else {
            return null;
        }
    }
}
