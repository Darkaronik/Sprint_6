package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    @Parameterized.Parameters(name = "sex={0}, mane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"Самец", true, false}, {"Самка", false, false},
            {"", false, true}, {"самец", false, true}, {null, false, true}
        });
    }
    private final String sex;
    private final boolean expectedMane;
    private final boolean invalid;
    public LionParameterizedTest(String sex, boolean expectedMane, boolean invalid) {
        this.sex = sex;
        this.expectedMane = expectedMane;
        this.invalid = invalid;
    }
    @Test public void shouldValidateSexAndSetMane() throws Exception {
        LionDependency dependency = mock(LionDependency.class);
        if (invalid) {
            assertThrows(Exception.class, () -> new Lion(sex, dependency));
        } else {
            assertEquals(expectedMane, new Lion(sex, dependency).doesHaveMane());
        }
    }
}
