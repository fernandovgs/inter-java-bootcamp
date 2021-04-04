package digital.innovation.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountAnalyzedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int even = 0, odd = 0, negative = 0, positive = 0;

        for (int i = 0; i < 5; i++) {
            var input = Integer.parseInt(br.readLine());

            even += input % 2 == 0 ? 1 : 0;
            odd += input % 2 != 0 ? 1 : 0;
            negative += input < 0 ? 1 : 0;
            positive += input > 0 ? 1 : 0;
        }

        System.out.println(String.format("%d valor(es) par(es)", even));
        System.out.println(String.format("%d valor(es) impar(es)", odd));
        System.out.println(String.format("%d valor(es) positivo(s)", positive));
        System.out.println(String.format("%d valor(es) negativo(s)", negative));
    }

}
