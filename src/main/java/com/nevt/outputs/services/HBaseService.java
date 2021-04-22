package com.nevt.outputs.services;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

@Service
public class HBaseService {
    @Autowired
    private Connection hbaseConnection;
//    private HbaseTemplate hbaseTemplate;


    /*
     * 制氢厂数据写入HBase数据库表
     * 数据库表RowKey = <data_source_id>:<timestamp>
     * @param dataSourceId 制氢厂ID，对应RowKey中data_source_id
     * @param timestamp 此数据时间戳，对应RowKey中timestamp
     * @param data 数据。Map定义为：Map<列簇名, Map<列名，值> >
     */
    public void writeHydrogenFactory(Long dataSourceId, Date timestamp, Map<String, Map<String, String>> data) throws IOException {

        //        Configuration configuration = HBaseConfiguration.create();
//        configuration.set("hbase.zookeeper.quorum", "cdata01:2181");
//        Connection connection = ConnectionFactory.createConnection(configuration);

        Table table = hbaseConnection.getTable(TableName.valueOf("data:hydrogen_factory_data"));

        DecimalFormat format = new DecimalFormat("000000");
        Put put = new Put(Bytes.toBytes(format.format(dataSourceId) + ":" + timestamp.getTime()));
        for (String key : data.keySet()) {
            for (String key_1 : data.get(key).keySet()) {
                put.addColumn(Bytes.toBytes(key), Bytes.toBytes(key_1), Bytes.toBytes(data.get(key).get(key_1)));
            }
        }

        table.put(put);

//        table.close();
//        hbaseConnection.close();

    }

}
