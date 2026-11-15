package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {
    @Test public void shouldReturnMeow() {
        assertEquals("Мяу", new Cat(mock(Feline.class)).getSound());
    }

    @Test public void shouldDelegateFoodToFeline() throws Exception {
        Feline feline = mock(Feline.class);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(food);
        assertEquals(food, new Cat(feline).getFood());
    }

    @Test public void shouldCallFelineForFood() throws Exception {
        Feline feline = mock(Feline.class);
        new Cat(feline).getFood();
        verify(feline).eatMeat();
    }

    @Test public void shouldPropagateFoodException() throws Exception {
        Feline feline = mock(Feline.class);
        Exception error = new Exception("food error");
        when(feline.eatMeat()).thenThrow(error);
        assertThrows(Exception.class, () -> new Cat(feline).getFood());
    }
}
