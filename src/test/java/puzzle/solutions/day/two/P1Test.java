package puzzle.solutions.day.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1Test {

    @Test
    public void testNull() {
        assertEquals(0, P1.solve(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(0, P1.solve("  "));
    }



}
