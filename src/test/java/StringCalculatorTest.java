import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorTest {

    private StringCalculator underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new StringCalculator();
    }

    @Test
    public void addWithNoNumber() {
        assertThat(underTest.add(""), is(0));
    }

    @Test
    public void addWithOneAsNumber() {
        assertThat(underTest.add("1"), is(1));
    }

    @Test
    public void addWithTwoAsNumber() {
        assertThat(underTest.add("2"), is(2));
    }

    @Test
    public void addWithOneAndTwoAsNumber() {
        assertThat(underTest.add("1,2"), is(3));
    }


    private class StringCalculator {
        public int add(String number) {
            if ("".equals(number)) return 0;
            if(!number.contains(",")) return Integer.parseInt(number);
            return Arrays.stream(number.split(",")).mapToInt(Integer::parseInt).sum();
        }
    }
}
