package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {
    @Test public void shouldDelegateKittenCount() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        when(dependency.getKittens()).thenReturn(3);
        assertEquals(3, new Lion("Самец", dependency).getKittens());
        verify(dependency).getKittens();
    }

    @Test public void shouldDelegateFood() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        List<String> food = List.of("Мясо");
        when(dependency.eatMeat()).thenReturn(food);
        assertEquals(food, new Lion("Самка", dependency).getFood());
        verify(dependency).eatMeat();
    }

    @Test public void shouldPropagateFoodException() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        Exception error = new Exception("food error");
        when(dependency.eatMeat()).thenThrow(error);
        Lion lion = new Lion("Самец", dependency);
        assertSame(error, assertThrows(Exception.class, lion::getFood));
    }
}
