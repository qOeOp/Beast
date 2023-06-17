package com.vincent.tfg.testcases;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import static org.slf4j.LoggerFactory.getLogger;


@SpringBootTest
public class Demo3Test {

    Logger logger = getLogger(Demo3Test.class);

    @Test
    void v1test(){
        logger.info("Step1:Hello");
    }

    @Test
    void v2test(){
        System.out.println();
    }

    @Test
    void v3test(){
        System.out.println();
    }
}
