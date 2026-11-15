package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {
    @Test public void shouldDelegateKittenCount() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        when(dependency.getKittens()).thenReturn(1);
        assertEquals(1, new Lion("Самец", dependency).getKittens());
    }

    @Test public void shouldCallDependencyForKittenCount() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        new Lion("Самец", dependency).getKittens();
        verify(dependency).getKittens();
    }

    @Test public void shouldDelegateFood() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(dependency.eatMeat()).thenReturn(food);
        assertEquals(food, new Lion("Самка", dependency).getFood());
    }

    @Test public void shouldCallDependencyForFood() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        new Lion("Самка", dependency).getFood();
        verify(dependency).eatMeat();
    }

    @Test public void shouldPropagateFoodException() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        Exception error = new Exception("food error");
        when(dependency.eatMeat()).thenThrow(error);
        Lion lion = new Lion("Самец", dependency);
        assertThrows(Exception.class, lion::getFood);
    }
}
