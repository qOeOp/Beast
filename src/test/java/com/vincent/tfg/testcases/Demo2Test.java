package com.vincent.tfg.testcases;

import com.vincent.tfg.annotation.JiraEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
public class Demo2Test {
    Logger logger = getLogger(Demo2Test.class);
    @Test
    void v1test(CapturedOutput output){
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        String all = output.getAll();
        System.out.println(all);
    }

    @Test
    void v2test(CapturedOutput output){
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        String all = output.getAll();
        System.out.println(all);
    }

    @Test
    @JiraEntry
    void v3test(CapturedOutput output){
        logger.info("Step1:Hello");
        logger.info("Step1:Hello2");
        logger.info("Step1:Hello3");
        logger.info("Step1:Hello4");
        String all = output.getAll();
        System.out.println(all);
    }
}
