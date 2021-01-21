package com.kodilla.patterns.factory.tasks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryPainting(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Tasks painting = factory.makeTask(TaskFactory.PAINTING);
        //then
        assertEquals("Painting fence", painting.getTaskName());
        assertEquals(false, painting.isTaskExecuted());
    }

    @Test
    void testFactoryShopping(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Tasks shopping = factory.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        //then
        assertEquals("Buy apples", shopping.getTaskName());
        assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    void testFactoryDriving(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Tasks driving = factory.makeTask(TaskFactory.DRIVING);
        driving.executeTask();
        //then
        assertEquals("Drive to work", driving.getTaskName());
        assertEquals(true, driving.isTaskExecuted());
    }
}
