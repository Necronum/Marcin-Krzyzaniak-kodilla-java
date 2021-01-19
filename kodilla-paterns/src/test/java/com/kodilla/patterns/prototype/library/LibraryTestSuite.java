package com.kodilla.patterns.prototype.library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //given
        Book book1 = new Book("300", "Mick", LocalDate.of(2019,1,12));
        Book book2 = new Book("Something", "Martin Lothar", LocalDate.of(1999,12,30));
        Book book3 = new Book("The Cat", "Amanda Tiger", LocalDate.of(1967,2,17));
        Library library = new Library("Library One");
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);

        //shallow copy
        Library shallowLibrary = null;
        try {
            shallowLibrary = library.shallowCopy();
            shallowLibrary.setName("Library Two");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //deep copy
        Library deepLibrary = null;
        try{
            deepLibrary = library.deepCopy();
            deepLibrary.setName("Library Three");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //when
        library.getBooks().remove(book2);

        //then
        System.out.println("Library: \n" + library.getBooks());
        System.out.println("Shallow Library: \n" + shallowLibrary.getBooks());
        System.out.println("Deep Library: \n" + deepLibrary.getBooks());
        assertEquals(2,library.getBooks().size());
        assertEquals(2,shallowLibrary.getBooks().size());
        assertEquals(3,deepLibrary.getBooks().size());
    }
}
