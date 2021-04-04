package digital.innovation.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Divisors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        br.close();

        int n = -1;

        // C is always multiple of A
        if (c % a == 0) {

            for (int i = a; i <= c / 2; i += a) {
                if (
                        i % a == 0 && // a is divisor of n
                        c % i == 0 && // c is multiple of n
                        (i % b != 0) && // b is not a divisor of n
                        (d % i != 0)    // d is not a multiple of n
                ) {
                    n = i;
                    break;
                }
            }
        }
        System.out.println(n);
    }
}
