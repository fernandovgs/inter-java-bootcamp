package digital.innovation.one.core;

import digital.innovation.one.utils.Calculator;

public class Runner {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.sum(7.0, 5.0));
    }
}
