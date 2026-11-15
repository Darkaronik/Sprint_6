package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    @Parameterized.Parameters(name = "kittens={0}, expected={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{0, 0}, {1, 1}, {5, 5}, {-1, -1}});
    }
    private final int count;
    private final int expected;
    public FelineParameterizedTest(int count, int expected) {
        this.count = count;
        this.expected = expected;
    }
    @Test public void shouldReturnProvidedKittenCount() {
        assertEquals(expected, new Feline().getKittens(count));
    }
}
