import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreams {
  public static void main(String[] args) {
    long init = System.currentTimeMillis();

    IntStream.range(1, 1000000)
      .forEach(n -> fatorial(n));

    long end = System.currentTimeMillis();
    System.out.println("Execution time (normal): " + (Double.parseDouble(Long.toString(end - init)) / 1000.0) + "s");

    init = System.currentTimeMillis();

    IntStream.range(1, 1000000)
      .parallel()
      .forEach(n -> fatorial(n));

    end = System.currentTimeMillis();
    System.out.println("Execution time: (parallel)" + (Double.parseDouble(Long.toString(end - init)) / 1000.0) + "s");

    List<String> names = Arrays.asList("Fernando", "Ana", "Aninha", "Walter");

    names.parallelStream().forEach(System.out::println);
  }

  public static long fatorial(long n) {
    long fat = 1;

    for (int i = 2; i <= n; i++) {
      fat = fat * i;
    }

    return fat;
  }
}
