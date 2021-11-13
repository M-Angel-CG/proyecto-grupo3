package com.example.proyectotesting.patterns.behavioral.iterator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BookShopTest")
class BookShopTest {


    @Test
    @DisplayName("Añadir libro")
    void addBook() {

        //Creo el libro
        Book libro1= new Book("1111","Autor1",1991);
        //Creo el objeto a testear
        BookShop shop= new BookShop();
        Iterator<Book> iterator=shop.iterator();
        assertFalse(iterator.hasNext());
        shop.addBook(libro1);
        assertTrue(iterator.hasNext());

    }

    @Test
    @DisplayName("Iterar")
    void iterator() {
        Book libro1= new Book("1111","Autor1",1991);
        Book libro2= new Book("2222","Autor2",1992);

        BookShop shop= new BookShop();
        shop.addBook(libro1);
        shop.addBook(libro2);

        Iterator<Book> iterator=shop.iterator();

        assertTrue(iterator.hasNext());
        Book libroi1=iterator.next();
        assertEquals("Autor1",libroi1.getAuthor());
        assertTrue(iterator.hasNext());
        Book libroi2=iterator.next();
        assertEquals("Autor2",libroi2.getAuthor());

        assertFalse(iterator.hasNext());

    }
}