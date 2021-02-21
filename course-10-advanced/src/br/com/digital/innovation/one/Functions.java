import java.util.function.Function;

public class Functions {
  public static void main(String[] args) {
    Function<String, String> reverseName = text -> new StringBuilder(text).reverse().toString();
    Function<String, Integer> strToInt = Integer::valueOf;
    Function<String, Integer> strToIntMult = n -> Integer.valueOf(n) * 2;

    System.out.println(reverseName.apply("Fernando"));
    System.out.println(strToInt.apply("10"));
    System.out.println(strToIntMult.apply("10"));
  }
}
