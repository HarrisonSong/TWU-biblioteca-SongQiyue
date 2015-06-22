package com.twu.biblioteca;

import java.util.LinkedList;
import static com.twu.biblioteca.PredefinedBooksDetails.*;
import static com.twu.biblioteca.MainMenuOptionConstants.*;

public class BibliotecaApp {
    private static LibraryManagementSystem LMS;

    public static void main(String[] args) {
        setup();
        LMS.startSystem();
    }

    private static void setup() {
        LinkedList<LibraryItem> booksList = new LinkedList<LibraryItem>();
        booksList.add(new Book(BOOK_ONE_NAME, BOOK_ONE_AUTHOR, BOOK_ONE_PUBLISHING_YEAR));
        booksList.add(new Book(BOOK_TWO_NAME, BOOK_TWO_AUTHOR, BOOK_TWO_PUBLISHING_YEAR));
        booksList.add(new Book(BOOK_THREE_NAME, BOOK_THREE_AUTHOR, BOOK_THREE_PUBLISHING_YEAR));
        booksList.add(new Book(BOOK_FOUR_NAME, BOOK_FOUR_AUTHOR, BOOK_FOUR_PUBLISHING_YEAR));
        booksList.add(new Book(BOOK_FIVE_NAME, BOOK_FIVE_AUTHOR, BOOK_FIVE_PUBLISHING_YEAR));

        LinkedList<String> menuList = new LinkedList<String>();
        menuList.add(MAIN_MENU_LIST_BOOKS_OPTION);
        menuList.add(MAIN_MENU_LIST_MOVIES_OPTION);

        LMS = new LibraryManagementSystem(booksList, menuList);
    }
}
