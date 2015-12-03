import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorTest {

    private Calculator underTest;

    @Before
    public void setup() {
        underTest = new Calculator();
    }


    @Test
    public void addingEmptyString_ReturnsZero() {
        assertThat(underTest.add(""), is(0));
    }

    @Test
    public void addOneNumberReturnsTheNumber() {
        assertThat(underTest.add("5"), is(5));
    }


    private class Calculator {
        public int add(String numbers) {
            return 0;
        }
    }
}
