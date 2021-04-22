package com.nevt.workers;

import com.nevt.service.DBService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@EnableScheduling
class PostgresTask {

    @Resource
    private DBService dbService;

    @Scheduled(fixedDelay = 10000)
    void test() {
        List<String> parameterNameList = dbService.getParameterNameList(2000005);
        Map<String, String> hBaseColumns = dbService.getHBaseColumns(parameterNameList);
        for (Map.Entry<String, String> s : hBaseColumns.entrySet()) {
            System.out.printf("postgresColumn: %20s \t HBaseColumn %s \n",s.getKey(),s.getValue());
        }
    }

}
