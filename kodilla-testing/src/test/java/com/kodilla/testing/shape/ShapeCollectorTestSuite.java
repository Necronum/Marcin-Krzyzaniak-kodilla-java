package com.kodilla.testing.shape;
import org.junit.jupiter.api.*;

@DisplayName("TDD: ShapeCollector Test Suite")
class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Testing add,remove and get methods")
    class TestAddRemove{
        @Test
        @DisplayName("Testing adding and getting figure")
        void testAddGetFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shape = new ShapeCollector();
            //When
            shape.addFigure(circle);
            //Then
            Assertions.assertEquals(circle, shape.getFigure(0));
        }

        @Test
        @DisplayName("Testing remove function")
        void testRemoveFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shape = new ShapeCollector();
            shape.addFigure(circle);
            //When
            boolean result = shape.removeFigure(circle);
            //Then
            Assertions.assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Testing showing method")
    class TestGet{
        @Test
        @DisplayName("Testing showing only names of all figures inside list")
        void testShowFigure(){
            //Given
            Circle circle = new Circle();
            Triangle triangle = new Triangle();
            ShapeCollector shape = new ShapeCollector();
            shape.addFigure(circle);
            shape.addFigure(triangle);
            String correctResult = "Circle, Triangle";
            //When
            String result = shape.showFigures();
            //Then
            Assertions.assertEquals(correctResult, result);
        }
    }
}
