package puzzle.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dec_1_P1Test {

    private Dec_1_P1 classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new Dec_1_P1();
    }

    @Test
    public void testNull() {
        assertEquals(0, classUnderTest.solve(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(0, classUnderTest.solve("  "));
    }

    @Test
    public void testNoDigits() {
        assertEquals(0, classUnderTest.solve("null"));
    }

    @Test
    public void test() {
        String testString = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet""";
        assertEquals(142, classUnderTest.solve(testString));
    }

}
