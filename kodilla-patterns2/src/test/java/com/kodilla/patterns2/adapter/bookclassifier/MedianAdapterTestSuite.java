
package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("Title1", "Author1",2000,"123");
        Book book2 = new Book("Title2", "Author2",2010,"456");
        Book book3 = new Book("Title3", "Author3",2020,"789");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int expectedMedian = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(expectedMedian, 2010);
    }
}