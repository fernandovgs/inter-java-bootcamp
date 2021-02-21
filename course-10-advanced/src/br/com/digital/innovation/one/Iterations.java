import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iterations {
  public static void main(String[] args) {
    String[] names = {"Fernando", "Ana", "Gueisha", "Johnson", "Igor", "Johnson"};

    printFilteredNames(names);
    printAllNames(names);
  }

  public static void printFilteredNames(String... names) {
    String namesToPrint = Stream.of(names)
      .filter(name -> name.equals("Johnson"))
      .collect(Collectors.joining());

    System.out.println("Nomes do stream: " + namesToPrint);
  }

  public static void printAllNames(String... names) {
    System.out.println("\n\nImprimindo todos os nomes pelo Stream.of");
    Stream.of(names)
      .forEach(System.out::println);
  }
}
