package com.nevt.common;

import java.util.*;

public interface Output {

    /**
     * 实现Dummy数据输出到目标存储（可能是HBase、文件、Kafka队列等），子类实现
     * @param 。byte[] 需要输出的数据
     */
    public void output(byte[] data);


}
