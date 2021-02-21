package digital.innovation.one.groupofwords;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestingWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer numberOfWords = Integer.valueOf(br.readLine());

        while (numberOfWords != 0) {
            System.out.println(testGroup(numberOfWords, br) ? "Conjunto Bom" : "Conjunto Ruim");
            numberOfWords = Integer.valueOf(br.readLine());
        }
    }

    private static Boolean testGroup(Integer numberOfWords, BufferedReader br) throws IOException {
        var goodGroup = true;
        List<String> words = new ArrayList<>();

        for (int i = 0; i < numberOfWords; i++) {
            var newWord = br.readLine();

            if (words.size() > 0 || !goodGroup) {
                for (String word : words) {
                    if (word.startsWith(newWord) || newWord.startsWith(word)) {
                        goodGroup = false;
                        break;
                    }
                }
            }

            words.add(newWord);
        }

        return goodGroup;
    }
}
