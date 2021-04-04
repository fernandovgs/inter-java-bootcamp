package digital.innovation.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> numbersCounted = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            Integer numberToCount = Integer.parseInt(br.readLine());
            Integer currentCount = numbersCounted.get(numberToCount);

            numbersCounted.put(numberToCount, currentCount != null ? currentCount + 1 : 1);
        }

        numbersCounted.entrySet().forEach(entry -> {
            System.out.println(String.format("%d aparece %d vez(es)", entry.getKey(), entry.getValue()));
        });
    }
}
