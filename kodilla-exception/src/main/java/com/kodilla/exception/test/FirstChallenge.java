package com.kodilla.exception.test;

public class FirstChallenge {

    public final double divide(double a, double b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        } finally {
            System.out.println("Remember never divide by 0!!!");
        }
    }
}