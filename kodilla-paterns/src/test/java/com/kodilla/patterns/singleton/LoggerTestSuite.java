package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void startLogger(){
        logger = Logger.LOG;
    }

    @Test
    void testGetLastLog(){
        //Given
        logger.log("Log number 1");
        //When & Then
        System.out.println(logger.getLastLog());
    }
}
