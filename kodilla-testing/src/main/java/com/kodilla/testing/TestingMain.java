package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. wprowadzenie do testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("\n Sprawdzenie poprawności działania klasy Calculator");
        Calculator calculator = new Calculator(20,30);
        int addResult = calculator.add();
        int substractResult = calculator.substract();

        System.out.println("Poprawność dodawania:");
        if (addResult == 50){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Poprawność odejmowania:");
        if (substractResult == -10){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
