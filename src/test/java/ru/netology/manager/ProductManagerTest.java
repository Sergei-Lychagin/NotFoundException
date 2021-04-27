package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book item1 = new Book(1, "Остров Сахалин", 2000, "Чехов Антон Павлович");
    private Book item2 = new Book(2, "Град обреченный", 1000, "Стругацкие Аркадий и Борис");
    private Book item3 = new Book(3, "dot com testing", 800, "Roman Savin");
    private Product item8 = new Product(8, "Test", 800);
    private Smartphone item4 = new Smartphone(4, "Honor", 3000, "Chine");
    private Smartphone item5 = new Smartphone(5, "Samsung", 2500, "Korea");
    private Smartphone item6 = new Smartphone(6, "Nokia", 10000, "Finland");
    private Smartphone item7 = new Smartphone(7, "xiaomi", 6000, "Finland");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
    }

    @Test
    public void shouldName() {
        Product[] actual = manager.searchBy("Град обреченный");
        Product[] expected = new Product[]{item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAuthor() {
        Product[] actual = manager.searchBy("Roman Savin");
        Product[] expected = new Product[]{item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManufacturer() {
        Product[] actual = manager.searchBy("Korea");
        Product[] expected = new Product[]{item5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldForTwoManufacturer() {
        Product[] actual = manager.searchBy("Finland");
        Product[] expected = new Product[]{item6, item7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldProduct() {

        assertArrayEquals(new Product[]{item8}, manager.searchBy("Test"));
    }

    @Test
    public void shouldSampleEmptySet() {

        assertArrayEquals(new Product[0], manager.searchBy("USD"));
    }

}