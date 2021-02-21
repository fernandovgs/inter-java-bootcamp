package br.com.digital.innovation.one.inference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenceExample {
    public static void main(String[] args) throws IOException {
      connectAndPrintURLJavaOracle();
        printNameComplete("Fernando", "Gianini");
        printSum(24, 1, 2, 7);
    }

    private static void connectAndPrintURLJavaOracle() throws IOException {
        var url = new URL("https://docs.oracle.com/javase/10/language");
        var urlConnection = url.openConnection();

        try(var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replace(">", ">\n"));
        } catch (Exception e) {

        }
    }

    public static void printNameComplete(String name, String surname) {
        var nickname = String.format("%s %s", name, surname);

        System.out.println(nickname);
    }

    public static void printSum(int... numbers) {
        var sum = 0;

        if (numbers.length > 0) {

            for (var number: numbers) {
                sum+= number;
            }

        }

        System.out.println(String.format("Number: %d", sum));
    }
}
