package digital.innovation.one.embarassinginterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class EmbarrassingInterview {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word;

        while ((word = br.readLine()) != null) {
            var halfSize = word.length() % 2 == 0 ? word.length() / 2 : (word.length() / 2) + 1;
            var found = false;

            for (var i = halfSize; i < word.length(); i++) {
                var substringToCmp = word.substring(0, i);
                var substringToRemove = word.substring(i);

                if (substringToCmp.endsWith(substringToRemove)) {
                    found = true;
                    System.out.println(substringToCmp);
                }
            }

            if (!found) {
                System.out.println(word);
            }
        }


    }
}
