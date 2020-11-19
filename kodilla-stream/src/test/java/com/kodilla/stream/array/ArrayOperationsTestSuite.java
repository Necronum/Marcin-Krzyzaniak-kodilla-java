package com.kodilla.stream.array;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        //Given
        int[] numbers = new int[5];
        numbers[0] = 3;
        numbers[1] = 2;
        numbers[2] = 4;
        numbers[3] = 1;
        numbers[4] = 5;

        //When
        System.out.println("Numbers in array: ");
        double average = ArrayOperations.getAverage(numbers);
        double expectedAverage = 3.0;

        //Then
        assertEquals(expectedAverage, average);
    }
}
