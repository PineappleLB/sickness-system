package com.sickness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * springboot启动类
 *
 * @author pineapple
 * @create 2019/3/9
 */
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableScheduling
public class SickNessApplication {

    public static void main(String [] args){
        SpringApplication.run(SickNessApplication.class, args);
    }

}
