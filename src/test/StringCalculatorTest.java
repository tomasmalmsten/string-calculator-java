import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void addTwoNumbersReturnsTheSum() {
        assertThat(underTest.add("1,2"), is(3));
    }

    @Test
    public void addThreeNumberWithOneCommaAndOneNewLinesReturnsTheSum() {
        assertThat(underTest.add("1,2\n3"), is(6));
    }


    private class Calculator {
        public int add(String numbers) {
            return "".equals(numbers) ? 0 : Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
        }
    }
}
