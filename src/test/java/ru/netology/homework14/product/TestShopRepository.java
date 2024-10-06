package ru.netology.homework14.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestShopRepository {

    ShopRepository products;
    Product tomato;
    Product cucumber;

    @BeforeEach
    public void setup() {
        products = new ShopRepository();
        tomato = new Product(89, "Помидор", 120);
        cucumber = new Product(72, "Огурец", 89);

        products.add(tomato);
        products.add(cucumber);
    }

    @Test
    public void shouldRemoveWithoutException(){
        products.remove(89);

        Product[] actual = products.findAll();
        Product[] expected = { cucumber };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWithException(){
        Assertions.assertThrows(NotFoundException.class, () -> {products.remove(99);});
    }

    @Test
    public void shouldAddWithoutException(){
        Product apple = new Product(808, "Яболоко", 90);
        products.add(apple);

        Product[] actual = products.findAll();
        Product[] expected = { tomato, cucumber, apple };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithException(){
        Product pelmeni = new Product(89, "Пельмени", 200);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {products.add(pelmeni);});
    }
}
