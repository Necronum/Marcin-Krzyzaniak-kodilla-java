package com.kodilla.stream;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\n Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("\n Poem beautifier");
        poemBeautifier.beautify("dog", String::toUpperCase);
        poemBeautifier.beautify("PUPPY", String::toLowerCase);
        poemBeautifier.beautify("        this is text with spaces before", String::trim);
        poemBeautifier.beautify("dog", (text -> "This is a " + text + " ABC"));
        poemBeautifier.beautify("dog", (text -> text.substring(0,1).toUpperCase() + text.substring(1)));

        System.out.println("\n Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
