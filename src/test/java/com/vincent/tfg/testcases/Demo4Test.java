package com.vincent.tfg.testcases;

import com.vincent.tfg.annotation.JiraEntry;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import static org.slf4j.LoggerFactory.getLogger;


@SpringBootTest
public class Demo4Test {

    Logger logger = getLogger(Demo4Test.class);

    @Test
    void v1test(){
        logger.info("Step1:Hello");
    }

    @Test
    void v2test(){
        System.out.println();
    }

    // plz config no test not failed
    @Test
    @JiraEntry
    void v3test(){
        System.out.println();
    }
}
