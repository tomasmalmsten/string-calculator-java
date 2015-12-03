import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorTest {

    @Test
    public void addingEmptyString_ReturnsZero() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(""), is(0));
    }

    private class Calculator {
        public int add(String numbers) {
            return 0;
        }
    }
}
