package digital.innovation.one;

import java.util.Arrays;

public class NewCalculator {
    public int sum(int... values) {
        return Arrays.stream(values).sum();
    }
}
