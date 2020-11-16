package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. wprowadzenie do testowania oprogramowania");

        System.out.println("\n Sprawdzenie poprawności działania klasy Calculator");
        Calculator calculator = new Calculator(20,30);
        int addResult = calculator.add();
        int subResult = calculator.substract();

        if ((addResult == 50) && (subResult == -10)){
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator has error!");
        }
    }
}
