import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorTest {

    private StringCalculator underTest;

    @Before
    public void setUp() {
        underTest = new StringCalculator();
    }

    @Test
    public void add_withEmptyString_returnZero() {
        assertThat(underTest.add(""), is(0));
    }

    @Test
    public void add_withSingleNumberReturnsNumber() {
        assertThat(underTest.add("3"), is(3));
    }

    @Test
    public void add_withTwoNumbers_separatedByComma_returnsSumOfNumbers() {
        assertThat(underTest.add("4,3"), is(7));
    }

    @Test
    public void add_withFourNumbers_separatedByComma_returnsSumOfNumbers() {
        assertThat(underTest.add("2,2,2,2"), is(8));
    }

    @Test
    public void add_withFourNumber_separatedByNewLine_returnsSumOfNumbers() {
        assertThat(underTest.add("2\n2\n2\n2\n"), is(8));
    }

    @Test
    public void add_withFourNumbers_sepratedByMixOfNewLineAndComma_returnsSum() {
        assertThat(underTest.add("2,2\n2,2"), is(8));
    }


    @Test
    public void add_withFourNumber_whereDelimiterIsSpecified_returnsSum() {
        assertThat(underTest.add("//;\n2;2;2;2"), is(8));
    }


    private class StringCalculator {
        public int add(String numbers) {
            if(numbers.length() < 1) return 0;
            if(numbers.length() < 2) return Integer.parseInt(numbers);
            if(Objects.equals(numbers.substring(0, 2), "//")) {
                String delimiter = numbers.substring(2, 3);
                String actualNumbers = numbers.substring(4, numbers.length());
                return Arrays.stream(
                        actualNumbers.split(delimiter))
                        .mapToInt(Integer::parseInt).sum();
            }

            return Arrays.stream(numbers.split(",|\n")).mapToInt(Integer::parseInt).sum();
        }

    }
}
