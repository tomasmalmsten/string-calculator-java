import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorTest {

    private StringCalculator underTest;

    @Before
    public void setUp() {
        underTest = new StringCalculator();
    }


    @Test
    public void add_noNumber_returnsZero() {
        assertThat(underTest.add(""), is(0));
    }

    @Test
    public void add_oneNumber_returnsNumber() {
        assertThat(underTest.add("4"), is(4));
    }

    @Test
    public void add_twoNumbers_returnsSumOfNumbers() {
        assertThat(underTest.add("4,3"), is(7));
    }

    @Test
    public void addFourNumbersSeparatedByComma_returnsSum() {
        assertThat(underTest.add("3,4,7,10"), is(24));
    }
    
    private class StringCalculator {
        public int add(String numbers) {

            return numbers.length() < 1 ? 0 :
                    Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
        }
    }
}
