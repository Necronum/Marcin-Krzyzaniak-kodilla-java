package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .mapToObj(n -> "#" + (n+1) + ". " + numbers[n])
                .forEach(System.out::println);
        OptionalDouble average = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();
        return average.getAsDouble();
    }
}
