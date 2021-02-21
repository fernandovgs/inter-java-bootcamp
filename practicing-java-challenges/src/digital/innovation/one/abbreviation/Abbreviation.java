package digital.innovation.one.abbreviation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;

import java.util.*;

public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String post = br.readLine();

        while (!post.equals(".")) {
            StringTokenizer st = new StringTokenizer(post, " ");

            Map<String, Integer> words = getWords(st);
            Map<String, SimpleEntry<String, Integer>> chosenWords = getChosenWords(words);
            var newPost = getNewPost(post, chosenWords);

            // Print results
            System.out.println(newPost);
            System.out.println(chosenWords.size());
            chosenWords.forEach((letter, word) -> System.out.println(String.format("%s. = %s", letter, word.getKey())));

            post = br.readLine();
        }
    }

    // If it has a letter with a corresponding letter, this function will evaluate if the given new word shrinks
    // text more efficiently
    private static SimpleEntry<String, Integer> insertIfMoreEfficient(
            SimpleEntry<String, Integer> l,
            String newKey,
            Integer newValue
    ) {
        return l.getValue() > newValue ? l : new SimpleEntry<>(newKey, newValue);
    }

    // Insert new entry for letter
    private static SimpleEntry<String, Integer> insertNew(String key, Integer value) {
        return new SimpleEntry<>(key, value);
    }

    /* Counting appearances for each word <word, nº of appearances> */
    private static HashMap<String, Integer> getWords(StringTokenizer st) {
        Map<String, Integer> words = new HashMap<>();
        while (st.hasMoreTokens()) {
            String nextWord = st.nextToken().toLowerCase();
            if (nextWord.length() >= 3) {
                words.put(nextWord, words.get(nextWord) != null ? words.get(nextWord) + 1 : 1);
            }
        }

        return (HashMap<String, Integer>) words;
    }

    /* Comparing, for each letter, which word better shrinks the given entry */
    private static Map<String, SimpleEntry<String, Integer>> getChosenWords(Map<String, Integer> words) {
        Map<String, SimpleEntry<String, Integer>> chosenWords = new TreeMap<>();
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            var letter = word.getKey().substring(0, 1);
            int totalShrink = word.getValue() * word.getKey().substring(2).length();

            chosenWords.computeIfPresent(
                    letter,
                    (k, v) -> insertIfMoreEfficient(chosenWords.get(k), word.getKey(), totalShrink)
            );

            chosenWords.computeIfAbsent(
                    letter,
                    l -> insertNew(word.getKey(), totalShrink)
            );
        }

        return chosenWords;
    }

    /* Get the new post, abbreviating the chosen words */
    private static String getNewPost(String post, Map<String, SimpleEntry<String, Integer>> chosenWords) {
        String newPost = post;
        for (Map.Entry<String, SimpleEntry<String, Integer>> substitute: chosenWords.entrySet()) {
            var toReplace = substitute.getValue().getKey();
            newPost = newPost.replaceAll("\\b" + toReplace + "\\b", substitute.getKey() + '.');
        }

        return newPost;
    }
}
