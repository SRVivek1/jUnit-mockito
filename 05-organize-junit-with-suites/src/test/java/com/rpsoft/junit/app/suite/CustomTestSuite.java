package com.rpsoft.junit.app.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.rpsoft.junit.app.ArrayUtilsTest;
import com.rpsoft.junit.app.StringUtilsTest;

@RunWith(Suite.class)
@SuiteClasses({ ArrayUtilsTest.class, StringUtilsTest.class })
public class CustomTestSuite {

}
