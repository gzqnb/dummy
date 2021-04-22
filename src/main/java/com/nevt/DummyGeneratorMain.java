package com.nevt;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.nevt"})
public class DummyGeneratorMain implements CommandLineRunner {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT:+00:00"));
    }

    public static void main(String[] args) {
        log.info("starting..");
        new SpringApplicationBuilder(DummyGeneratorMain.class)
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        System.out.println("exiting..");
    }

    @Override
    public void run(String... args) throws Exception {
        return ;
//        while(true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}