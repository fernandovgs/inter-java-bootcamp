import java.util.function.Consumer;

public class Consumers {
  public static void main(String[] args) {
    Consumer<String> printPhrase = System.out::println;

    printPhrase.accept("Hello world");
  }
}
