package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    String beautifier;

    public void beautify(String text, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(text);
        System.out.println("Text after beautifier: " + result);
    }
}
