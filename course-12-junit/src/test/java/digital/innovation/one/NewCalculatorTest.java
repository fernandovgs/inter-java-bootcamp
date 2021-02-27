package digital.innovation.one;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewCalculatorTest {

    @Test
    void mustSumTwoValues() {
        int valA = 1;
        int valB = 2;

        NewCalculator newCalc = new NewCalculator();
        int sum = newCalc.sum(valA, valB);

        assertEquals(3, sum);
    }

    @Test
    void mustSumThreeValues() {
        int valA = 1;
        int valB = 2;
        int valC = 3;

        NewCalculator newCalc = new NewCalculator();
        int sum = newCalc.sum(valA, valB, valC);

        assertEquals(6, sum);
    }
}
