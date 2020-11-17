package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when create OddNubmersExterminator with empty list, " +
            "then exterminate should return result with empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator numbers = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = numbers.exterminate(emptyList);
        System.out.println("Testing with empty list");
        //Then
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("when create OddNumbersExterminator with List of Integers, " +
            "then exterminate should return correct sublist"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator numbers = new OddNumbersExterminator();
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> correctResult = new ArrayList<>(Arrays.asList(2,4,6));
        //When
        List<Integer> result = numbers.exterminate(integerList);
        System.out.println("Testing with: " + result);
        //Then
        Assertions.assertEquals(correctResult, result);
    }
}
