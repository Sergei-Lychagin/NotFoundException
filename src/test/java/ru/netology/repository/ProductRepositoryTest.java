package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "fffff", 500, "sssss");
    private Smartphone second = new Smartphone(2, "Samsung", 5000, "Samsung");

    @BeforeEach
    public void setup() {
        repository.save(first);
        repository.save(second);
    }

    @Test
    void save() {

        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void removeById() {

        int idToRemove = 2;
        repository.removeById(idToRemove);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }



    @Test
    void shouldThrowExInRemoveByIdIfIdNotExists() {
        int id = 0;
        NotFoundException thrown = assertThrows(NotFoundException.class,
                () -> repository.removeById(id)
        );
        thrown.printStackTrace();
    }
}