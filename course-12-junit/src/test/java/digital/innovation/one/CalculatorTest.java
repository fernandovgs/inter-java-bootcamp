package digital.innovation.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculatorTest {
    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        var sum = calculator.sum("1+3+5+7");
        assertEquals(16, sum);
    }

    @Test
    void sumWithMock() {
        Calculator calculator = mock(Calculator.class);

        when(calculator.sum("1+2+3")).thenReturn(6);

        int res = calculator.sum("1+2+3");
        assertEquals(6, res);
    }
}