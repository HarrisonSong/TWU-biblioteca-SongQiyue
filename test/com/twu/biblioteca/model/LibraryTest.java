package com.twu.biblioteca.model;

import com.twu.biblioteca.LibraryItem;
import com.twu.biblioteca.SystemMessageType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static com.twu.biblioteca.PredefinedBooksDetails.*;
import static com.twu.biblioteca.PredefinedMovieDetails.*;
import static com.twu.biblioteca.PredefinedUserDetails.*;
import static org.junit.Assert.*;

/**
 * Created by qiyuesong on 18/6/15.
 */
public class LibraryTest {
    private Library library;
    private Book bookA, bookB, bookC, bookD, bookE;
    private Movie movieA, movieB, movieC, movieD;
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private Customer customer;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outStream));

        bookA = new Book(BOOK_ONE_NAME, BOOK_ONE_AUTHOR, BOOK_ONE_PUBLISHING_YEAR);
        bookB = new Book(BOOK_TWO_NAME, BOOK_TWO_AUTHOR, BOOK_TWO_PUBLISHING_YEAR);
        bookC = new Book(BOOK_THREE_NAME, BOOK_THREE_AUTHOR, BOOK_THREE_PUBLISHING_YEAR);
        bookD = new Book(BOOK_FOUR_NAME, BOOK_FOUR_AUTHOR, BOOK_FOUR_PUBLISHING_YEAR);
        bookE = new Book(BOOK_FIVE_NAME, BOOK_FIVE_AUTHOR, BOOK_FIVE_PUBLISHING_YEAR);

        movieA = new Movie(MOVIE_ONE_NAME, MOVIE_ONE_YEAR, MOVIE_ONE_DIRECTOR, MOVIE_ONE_RATING);
        movieB = new Movie(MOVIE_TWO_NAME, MOVIE_TWO_YEAR, MOVIE_TWO_DIRECTOR, MOVIE_TWO_RATING);
        movieC = new Movie(MOVIE_THREE_NAME, MOVIE_THREE_YEAR, MOVIE_THREE_DIRECTOR, MOVIE_THREE_RATING);
        movieD = new Movie(MOVIE_FOUR_NAME, MOVIE_FOUR_YEAR, MOVIE_FOUR_DIRECTOR, MOVIE_FOUR_RATING);

        LinkedList<LibraryItem> itemsList = new LinkedList<LibraryItem>();
        itemsList.add(bookA);
        itemsList.add(bookB);
        itemsList.add(bookC);
        itemsList.add(bookD);
        itemsList.add(bookE);
        itemsList.add(movieA);
        itemsList.add(movieB);
        itemsList.add(movieC);
        itemsList.add(movieD);

        library = new Library(itemsList);
        customer = new Customer(CUSTOMER_ONE_NAME, CUSTOMER_TWO_EMAIL, CUSTOMER_ONE_PHONENUMBER);
    }

    @After
    public void cleanUp(){
        System.setOut(null);
    }

    @Test
    public void testGetAllItemsList(){
        assertEquals(9, library.getItemsList().size());
    }

    @Test
    public void testGetAllBooksList(){
        assertEquals(5, library.getAllBooksList().size());
    }

    @Test
    public void testGetAllMoviesList(){
        assertEquals(4, library.getAllMoviesList().size());
    }

    @Test
    public void testGetAvailableItemListAfterBookAHasBeenCheckedOut(){
        assertEquals(9, library.getAvailableItemsList().size());
        bookA.checkOut();
        assertEquals(8, library.getAvailableItemsList().size());
    }

    @Test
    public void testGetAvailableBooksListAfterBookAHasBeenCheckedOut(){
        assertEquals(5, library.getAvailableBooksList().size());
        bookA.checkOut();
        assertEquals(4, library.getAvailableBooksList().size());
    }

    @Test
    public void testGetAvailableMoviesListAfterBookAHasBeenCheckedOut(){
        assertEquals(4, library.getAvailableMoviesList().size());
        bookA.checkOut();
        assertEquals(4, library.getAvailableMoviesList().size());
    }

    @Test
    public void testGetAvailableItemListAfterMovieAHasBeenCheckedOut(){
        assertEquals(9, library.getAvailableItemsList().size());
        bookA.checkOut();
        assertEquals(8, library.getAvailableItemsList().size());
    }

    @Test
    public void testGetAvailableBooksListAfterMovieAHasBeenCheckedOut(){
        assertEquals(5, library.getAvailableBooksList().size());
        movieA.checkOut();
        assertEquals(5, library.getAvailableBooksList().size());
    }

    @Test
    public void testGetAvailableMoviesListAfterMovieAHasBeenCheckedOut(){
        assertEquals(4, library.getAvailableMoviesList().size());
        movieA.checkOut();
        assertEquals(3, library.getAvailableMoviesList().size());
    }

    @Test
    public void testGetAvailableItemListAfterBookAHasBeenCheckedIn(){
        bookA.checkOut();
        assertEquals(8, library.getAvailableItemsList().size());
        bookA.checkIn();
        assertEquals(9, library.getAvailableItemsList().size());
    }

    @Test
    public void testGetAvailableBooksListAfterBookAHasBeenCheckedIn(){
        bookA.checkOut();
        assertEquals(4, library.getAvailableBooksList().size());
        bookA.checkIn();
        assertEquals(5, library.getAvailableBooksList().size());
    }

    @Test
    public void testGetAvailableMoviesListAfterMovieAHasBeenCheckedIn(){
        bookA.checkOut();
        assertEquals(4, library.getAvailableMoviesList().size());
        bookA.checkIn();
        assertEquals(4, library.getAvailableMoviesList().size());
    }

    @Test
    public void testGetAvailableItemListAfterMovieAHasBeenCheckedIn(){
        movieA.checkOut();
        assertEquals(8, library.getAvailableItemsList().size());
        movieA.checkIn();
        assertEquals(9, library.getAvailableItemsList().size());
    }

    @Test
    public void testGetAvailableBooksListAfterMovieAHasBeenCheckedIn(){
        movieA.checkOut();
        assertEquals(5, library.getAvailableBooksList().size());
        movieA.checkIn();
        assertEquals(5, library.getAvailableBooksList().size());
    }

    @Test
    public void testGetAvailableMoviesListAfterBookAHasBeenCheckedIn(){
        movieA.checkOut();
        assertEquals(3, library.getAvailableMoviesList().size());
        movieA.checkIn();
        assertEquals(4, library.getAvailableMoviesList().size());
    }

    @Test
    public void testShowAvailableBooksList(){
        bookA.checkOut();
        library.showAvailableBooksList();
        assertEquals("The Old Man and the Sea Ernest Hemingway 1990\n" +
                "Programming Pearl Jon Bentley 2003\n" +
                "Hamlet Shakespeare 1972\n" +
                "Gone with the wind Margaret Mitchell 1980\n", outStream.toString());
        outStream.reset();

        bookD.checkOut();
        library.showAvailableBooksList();
        assertEquals("The Old Man and the Sea Ernest Hemingway 1990\n" +
                "Programming Pearl Jon Bentley 2003\n" +
                "Gone with the wind Margaret Mitchell 1980\n", outStream.toString());
    }

    @Test
    public void testShowAvailableMoviesList(){
        movieA.checkOut();
        library.showAvailableMoviesList();
        assertEquals("Jurassic Park 1990 Spielberg 7\n" +
                "007 2001 Louis 7\n" +
                "Lord of the Ring 2002 Tom 8\n", outStream.toString());
        outStream.reset();

        movieA.checkIn();
        library.showAvailableMoviesList();
        assertEquals("Star War 1996 Jim 9\n" +
                "Jurassic Park 1990 Spielberg 7\n" +
                "007 2001 Louis 7\n" +
                "Lord of the Ring 2002 Tom 8\n", outStream.toString());
    }

    @Test
    public void testFindItem(){
        assertNotNull(library.findItem(BOOK_ONE_NAME));
        assertNotNull(library.findItem(MOVIE_TWO_NAME));
        assertNull(library.findItem("Galaxy War"));
    }

    @Test
    public void testBookAIsAvailable(){
        assertNotNull(library.findItemIfAvailable(BOOK_ONE_NAME));
        assertTrue(library.findItemIfAvailable(BOOK_ONE_NAME) instanceof Book);
    }

    @Test
    public void testBookAIsNotAvailableAfterBeingCheckedOut(){
        bookA.checkOut();
        assertNull(library.findItemIfAvailable(BOOK_ONE_NAME));
    }

    @Test
    public void testMovieAIsAvailable(){
        assertNotNull(library.findItemIfAvailable(MOVIE_ONE_NAME));
        assertTrue(library.findItemIfAvailable(MOVIE_ONE_NAME) instanceof Movie);
    }

    @Test
    public void testMovieAIsNotAvailableAfterBeingCheckedOut(){
        movieA.checkOut();
        assertNull(library.findItemIfAvailable(MOVIE_ONE_NAME));
    }

    @Test
    public void testBuyBookA(){
        Assert.assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("buy One Hundred Years of Solitude", customer));
        assertFalse(bookA.getCheckOutStatus());
    }

    @Test
    public void testSellBookA(){
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("sell One Hundred Years of Solitude", customer));
        assertFalse(bookA.getCheckOutStatus());
    }

    @Test
    public void testBorrowBookA(){
        assertEquals(SystemMessageType.SUCCESSFUL_CHECKOUT, library.processLibraryItemsOperations("borrow One Hundred Years of Solitude", customer));
        assertTrue(bookA.getCheckOutStatus());
    }

    @Test
    public void testBorrowUnknownBook(){
        bookA.checkOut();
        assertEquals(SystemMessageType.UNSUCCESSFUL_CHECKOUT, library.processLibraryItemsOperations("borrow One", customer));
    }

    @Test
    public void testSellBookBAfterBorrowing(){
        bookB.checkOut();
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("sell The Old Man and the Sea", customer));
        assertTrue(bookB.getCheckOutStatus());
    }

    @Test
    public void testBuyBookBAfterBorrowing(){
        bookB.checkOut();
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("buy The Old Man and the Sea", customer));
        assertTrue(bookB.getCheckOutStatus());
    }

    @Test
    public void testReturnBookBAfterBorrowing(){
        customer.borrowItem(bookB);
        assertEquals(SystemMessageType.SUCCESSFUL_RETURN, library.processLibraryItemsOperations("return The Old Man and the Sea", customer));
        assertFalse(bookB.getCheckOutStatus());
    }

    @Test
    public void testReturnUnknownBookAfterBorrowingBookB(){
        customer.borrowItem(bookB);
        assertEquals(SystemMessageType.UNSUCCESSFUL_RETURN, library.processLibraryItemsOperations("return Galaxy War", customer));
    }

    @Test
    public void testBuyMovieA(){
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("buy Star War", customer));
        assertFalse(movieA.getCheckOutStatus());
    }

    @Test
    public void testSellMovieA(){
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("sell Star War", customer));
        assertFalse(movieA.getCheckOutStatus());
    }

    @Test
    public void testBorrowMovieA(){
        assertEquals(SystemMessageType.SUCCESSFUL_CHECKOUT, library.processLibraryItemsOperations("borrow Star War", customer));
        assertTrue(movieA.getCheckOutStatus());
    }

    @Test
    public void testBorrowUnknownMovie(){
        movieA.checkOut();
        assertEquals(SystemMessageType.UNSUCCESSFUL_CHECKOUT, library.processLibraryItemsOperations("borrow One", customer));
    }

    @Test
    public void testSellMovieBAfterBorrowing(){
        movieB.checkOut();
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("sell Jurassic Park", customer));
        assertTrue(movieB.getCheckOutStatus());
    }

    @Test
    public void testBuyMovieBAfterBorrowing(){
        movieB.checkOut();
        assertEquals(SystemMessageType.INVALID_LIBRARY_ITEM_OPTION, library.processLibraryItemsOperations("buy Jurassic Park", customer));
        assertTrue(movieB.getCheckOutStatus());
    }

    @Test
    public void testReturnMovieBAfterBorrowing(){
        customer.borrowItem(movieB);
        assertEquals(SystemMessageType.SUCCESSFUL_RETURN, library.processLibraryItemsOperations("return Jurassic Park", customer));
        assertFalse(movieB.getCheckOutStatus());
    }

    @Test
    public void testReturnUnknownMovieAfterBorrowingMovieB(){
        customer.borrowItem(movieB);
        assertEquals(SystemMessageType.UNSUCCESSFUL_RETURN, library.processLibraryItemsOperations("return Lingo", customer));
    }
}
