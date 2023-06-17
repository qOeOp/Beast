package com.vincent.tfg.testcases;

import com.vincent.tfg.annotation.Beast;
import com.vincent.tfg.annotation.JiraEntry;
import com.vincent.tfg.context.BeastContext;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import static org.slf4j.LoggerFactory.getLogger;

@Beast
@SpringBootTest
public class Demo1Test {

    Logger logger = getLogger(Demo1Test.class);

    @Test
    void v1test(BeastContext context){
        logger.info("===> Step1");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
        logger.info("===> Step2");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
        logger.info("===> Step3");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
    }

    @Test
    void v2test(BeastContext context){
        logger.info("===> Step1");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
        logger.info("===> Step2");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
        logger.info("===> Step3");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
    }

    @Test
    @JiraEntry
    void v3test(BeastContext context){
        logger.info("===> Step1");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
        logger.info("===> Step2");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
        logger.info("===> Step3");
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        logger.info("<=== END");
    }
}
