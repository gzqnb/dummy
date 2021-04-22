package com.nevt;

import com.nevt.outputs.services.HBaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest()
class HBaseTest {

    @Resource
    HBaseService hbaseService;

    @Test
    void testWrite() throws IOException {
        System.out.println("enter HBaseTest.testWrite");
        Map<String, Map<String, String>> data = new HashMap<>();
        Map<String, String> values1 = new HashMap<>();

        values1.put("o1", "0.1");
        values1.put("o2", "0.2");
        values1.put("o3", "0.3");
        values1.put("h1", "1.1");
        values1.put("h2", "1.2");
        values1.put("h3", "1.3");

        data.put("electrolyzer", values1);
        System.out.println(2);

        hbaseService.writeHydrogenFactory(1L, new Date(), data);
    }
}
