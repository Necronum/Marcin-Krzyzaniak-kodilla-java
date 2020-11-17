package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. wprowadzenie do testowania oprogramowania");

        System.out.println("\n Sprawdzenie poprawności działania klasy Calculator");
        Calculator calculator = new Calculator();
        int addResult = calculator.add(20, 30);
        int subResult = calculator.substract(40, 10);

        if ((addResult == 50) && (subResult == 30)){
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator has error!");
        }
    }
}
