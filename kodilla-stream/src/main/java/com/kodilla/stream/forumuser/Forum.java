package com.kodilla.stream.forumuser;

import com.kodilla.stream.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1, "martin123", 'M',
                LocalDate.of(1994, 6, 12), 100));
        usersList.add(new ForumUser(2, "martha90", 'F',
                LocalDate.of(1999, 12, 6), 54));
        usersList.add(new ForumUser(3, "adam123", 'M',
                LocalDate.of(1984, 4, 27), 0));
        usersList.add(new ForumUser(4, "kitty666", 'F',
                LocalDate.of(1996, 8, 15), 1));
        usersList.add(new ForumUser(5, "johns", 'M',
                LocalDate.of(2000, 11, 19), 2));
        usersList.add(new ForumUser(6, "forumking", 'M',
                LocalDate.of(2000, 11, 20), 999));
        usersList.add(new ForumUser(7, "forummaster", 'M',
                LocalDate.of(1984, 11, 20), 1));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(usersList);
    }
}
