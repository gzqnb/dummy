package com.nevt.common;

public interface Formatter {

    /**
     * @param data
     * @return
     */
    public byte[] format(Envelope data);

    /**
     * @param bytes
     * @return
     */
    public Envelope parse(byte[] bytes);

}
