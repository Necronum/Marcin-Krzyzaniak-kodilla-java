package com.kodilla.testing.library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    @DisplayName("Test for returning results with fragment of title")
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    @DisplayName("Test for safety if user has more than 20 books")
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    @DisplayName("Test for searching with less than 3 symbols for fragment of title")
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        lenient().when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    @DisplayName("Test for showing how many books user has")
    void testListBooksInHandsOf(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "123456789");
        LibraryUser libraryUser1 = new LibraryUser("Sarah", "Apple", "987654321");
        LibraryUser libraryUser2 = new LibraryUser("Adam", "Row", "123459876");
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf1Book = generateListOfNBooks(1);
        List<Book> resultListOf5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOf5Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(resultListOf1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(resultListOf0Books);

        //When
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser);
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser2);

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(1, theListOfBooks1.size());
        assertEquals(5, theListOfBooks5.size());
    }
}