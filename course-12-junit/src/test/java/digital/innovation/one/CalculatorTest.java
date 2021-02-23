package digital.innovation.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        var sum = calculator.sum("1+3+5+7");
        assertEquals(16, sum);
    }
}