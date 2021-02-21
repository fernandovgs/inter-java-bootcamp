package br.com.digital.innovation.one.inference;

import java.util.function.Function;

public class InferenceLambda {
    public static void main(String[] args) {
        Function<Integer, Double> divBy2 = (var number) -> number / 2.0;

        System.out.println(divBy2.apply(22222));
    }
}
