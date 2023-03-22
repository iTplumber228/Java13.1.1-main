package ru.netology.javaqamvn.services.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqamvn.services.domain.Book;
import ru.netology.javaqamvn.services.domain.NotFoundException;
import ru.netology.javaqamvn.services.domain.Product;
import ru.netology.javaqamvn.services.domain.Smartphone;
import ru.netology.javaqamvn.services.repository.ProductRepository;

public class ProductRepositoryTest {

    @Test
    public void testRemoveWhenProductNotExist() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Book1", 100, "John Johnson");
        Book book2 = new Book(2, "Book2", 200, "James Johnson");
        Book book3 = new Book(3, "Book3", 300, "Jack Johnson");
        Smartphone phone1 = new Smartphone(4, "Smartphone1", 400, "Some Company");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);


        Assertions.assertThrows(NotFoundException.class,
                ()-> repo.removeById(10)
        );

    }
    @Test

    public void testRemoveById() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book1", 100, "John Johnson");
        Book book2 = new Book(2, "Book2", 200, "James Johnson");
        Book book3 = new Book(3, "Book3", 300, "Jack Johnson");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        repo.removeById(2);

        Product[] expected = {book1, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindAll() {

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

        Product[] expected = {book1, book2, book3, phone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }




}
