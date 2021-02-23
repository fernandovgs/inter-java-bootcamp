package digital.innovation.one;

public class Calculator {
    public int sum(String expression) {
        int sum = 0;
        for (String sumVal : expression.split("\\+")) {
            sum += Integer.parseInt(sumVal);
        }

        System.out.println(sum);
        return sum;
    }
}
