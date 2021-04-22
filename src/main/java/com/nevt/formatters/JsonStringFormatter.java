package com.nevt.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nevt.common.Envelope;
import com.nevt.common.Formatter;

import java.io.IOException;

/**
 *
 */
public class JsonStringFormatter implements Formatter {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Default constructor
     */
    public JsonStringFormatter() {
    }

    /**
     * @param data
     * @return
     */
    public byte[] format(Envelope data) {
        byte[] by = null;
        try {
            by = mapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return by;
    }

    public String formatStr(Envelope data){
        String str = "";
        try {
            str = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @param bytes
     * @return
     */
    public Envelope parse(byte[] bytes) {
        Envelope en = null;
        try {
            en = mapper.readValue(bytes, Envelope.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return en;
    }

}