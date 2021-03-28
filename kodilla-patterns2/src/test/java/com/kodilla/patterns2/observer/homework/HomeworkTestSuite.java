package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        // Given
        HomeworkReport marcinKrzyzaniak = new Student1();
        HomeworkReport adrianWstepny = new Student2();
        HomeworkReport kingaProbna = new Student3();
        Mentor mateuszR = new Mentor("MateuszR");
        Mentor tadeuszK = new Mentor("TadeuszK");
        marcinKrzyzaniak.registerObserver(mateuszR);
        adrianWstepny.registerObserver(tadeuszK);
        kingaProbna.registerObserver(mateuszR);
        // When
        marcinKrzyzaniak.addHomework("1.1. Starting programming");
        adrianWstepny.addHomework("5.5. REST API");
        kingaProbna.addHomework("2.3. ArrayLists");
        marcinKrzyzaniak.addHomework("1.2. Types of variable");
        marcinKrzyzaniak.addHomework("1.3. What is object?");
        // Then
        assertEquals(4, mateuszR.getUpdateCount());
        assertEquals(1, tadeuszK.getUpdateCount());
    }
}