package com.kodilla.stream;
/*import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.beautifier.PoemBeautifier;*/
//import com.kodilla.stream.person.People;

/*import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;*/
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
/*        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

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

        //Poem beautifier code
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println("\n Poem beautifier");
        poemBeautifier.beautify("dog", String::toUpperCase);
        poemBeautifier.beautify("PUPPY", String::toLowerCase);
        poemBeautifier.beautify("        this is text with spaces before", String::trim);
        poemBeautifier.beautify("dog", (text -> "This is a " + text + " ABC"));
        poemBeautifier.beautify("dog", (text -> text.substring(0,1).toUpperCase() + text.substring(1)));

        System.out.println("\n Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/

/*        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.charAt(0) == 'M')
                .forEach(System.out::println);*/

       /* BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));
        System.out.println(theResultStringOfBooks);*/

        //Forum User code
        Forum theForumUser = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = theForumUser.getList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> ((LocalDate.now().getYear()*10000+(LocalDate.now().getMonthValue()*100)+(LocalDate.now().getDayOfMonth())) )
                        - ((user.getBirthDate().getYear()*10000)+(user.getBirthDate().getMonthValue()*100)+(user.getBirthDate().getDayOfMonth())) >=200000)
                .filter(user -> user.getPostsNumber() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        System.out.println("#elements: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
