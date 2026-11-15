package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {
    private final Feline feline = new Feline();

    @Test public void shouldReturnPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test public void shouldReturnFelineFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test public void shouldReturnOneKittenByDefault() {
        assertEquals(1, feline.getKittens());
    }
}
