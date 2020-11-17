package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("TDD: Weather Forecast Test Suite")
class WeatherForecastTestSuite {
    private static int testCounter = 0;

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    public void beforeEveryTest() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Test
    @DisplayName("Testing forecast insertion")
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    @DisplayName("Testing average calculation")
    void testCalculateAverageTemperatureWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double correctResult = 25.56;

        //When
        double result = weatherForecast.getAverage();

        //Then
        Assertions.assertEquals(correctResult, result);
    }

    @Test
    @DisplayName("Testing median calculation")
    void testCalculateMedianWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double correctResult = 25.5;

        //When
        double result = weatherForecast.getMedian();

        //Then
        Assertions.assertEquals(correctResult, result);
    }
}