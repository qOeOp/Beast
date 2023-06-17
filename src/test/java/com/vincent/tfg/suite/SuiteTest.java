package com.vincent.tfg.suite;

import com.vincent.tfg.testcases.Demo1Test;
import com.vincent.tfg.testcases.Demo2Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SelectClasses({Demo1Test.class, Demo2Test.class})
public class SuiteTest {

}
