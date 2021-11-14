package com.example.proyectotesting.patterns.behavioral.iterator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BookShopTest")
class BookShopTest {

    BookShop bookShop;
    @BeforeEach
    void setUp() {
        bookShop = new BookShop();
    }

    @Test
    @DisplayName("Añadir libro")
    void addBook() {

        Book book = new Book("a","b",1);
        bookShop.addBook(book);
        assertTrue(bookShop.books.size() == 1);

    }

    @Nested
    @DisplayName("Iterator Metodos")
    public class BookShopIteratorTests {

        Iterator<Book> bookiter;
        Book book;

        @BeforeEach
        void setUp(){
            book= new Book("a","b",1);
            bookShop.addBook(book);
            bookiter = bookShop.iterator();
        }

        @Test
        @DisplayName("Iterador con libros")
        void hasNextTrueTest() {assertTrue(bookiter.hasNext());}

        @Test
        @DisplayName("Iterador no hay mas libros")
        void hasNextFalseTest() {
            bookiter.next();
            assertFalse(bookiter.hasNext());
        }

        @Test
        @DisplayName("Excepcion si no hay mas libros")
        void nextThrowsTest() {
            //if(!hasNext())
            bookiter.next();
            assertThrows(NoSuchElementException.class,()->bookiter.next());
        }

        @Test
        @DisplayName("Cambia al siguiente libro")
        void nextOKTest() {assertEquals(book, bookiter.next());}
    }
}