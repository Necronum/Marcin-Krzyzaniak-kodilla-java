package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        TaskList toDo = board.getToDoList();
        TaskList inProgress = board.getInProgressList();
        TaskList done = board.getDoneList();

        toDo.addTaskToTheList("pass the exam");
        inProgress.addTaskToTheList("start learning");
        done.addTaskToTheList("order pizza");

        //When & Then
        System.out.println("================");
        System.out.println("ToDo list: ");
        Arrays.stream(board.getToDoList().getTasks().toArray())
                .forEach(System.out::println);
        System.out.println("================");
        System.out.println("In progress list: ");
        Arrays.stream(board.getInProgressList().getTasks().toArray())
                .forEach(System.out::println);
        System.out.println("================");
        System.out.println("Done list: ");
        Arrays.stream(board.getDoneList().getTasks().toArray())
                .forEach(System.out::println);
        System.out.println("================");
    }
}
