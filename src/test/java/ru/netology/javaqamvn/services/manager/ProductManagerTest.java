package ru.netology.javaqamvn.services.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqamvn.services.domain.Book;
import ru.netology.javaqamvn.services.domain.Product;
import ru.netology.javaqamvn.services.domain.Smartphone;
import ru.netology.javaqamvn.services.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    public void testWhenFewProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book1", 100, "John Johnson");
        Book book2 = new Book(2, "Book2", 200, "James Johnson");
        Book book3 = new Book(3, "Book3", 300, "Jack Johnson");
        Smartphone phone1 = new Smartphone(4, "Smartphone1", 400, "Some Company");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        Product[] actual = manager.searchBy("Book");
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void testWhenNoProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book1", 100, "John Johnson");
        Book book2 = new Book(2, "Book2", 200, "James Johnson");
        Book book3 = new Book(3, "Book3", 300, "Jack Johnson");
        Smartphone phone1 = new Smartphone(4, "Smartphone1", 400, "Some Company");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        Product[] actual = manager.searchBy("Notebook");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testWhenOneProductFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book1", 100, "John Johnson");
        Book book2 = new Book(2, "Book2", 200, "James Johnson");
        Book book3 = new Book(3, "Book3", 300, "Jack Johnson");
        Smartphone phone1 = new Smartphone(4, "Smartphone1", 400, "Some Company");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        Product[] actual = manager.searchBy("Smartphone1");
        Product[] expected = {phone1};

        Assertions.assertArrayEquals(expected, actual);
    }


}