package exercises.exercise6;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Exercise6 {
  public static void main(String[] args) {
    List<Optional<String>> tests = new ArrayList<>();
    
    tests.add(Optional.empty());
    tests.add(Optional.ofNullable("Teste 7"));
    tests.add(Optional.ofNullable(null));
    tests.add(Optional.ofNullable("Teste 2"));
    tests.add(Optional.ofNullable(null));
    tests.add(Optional.ofNullable("Teste 6"));
    tests.add(Optional.ofNullable(null));
    tests.add(Optional.ofNullable("Teste 4"));
    tests.add(Optional.ofNullable("Teste 1"));
    tests.add(Optional.ofNullable(null));
    tests.add(Optional.ofNullable("Teste 3"));
    tests.add(Optional.ofNullable(null));
    tests.add(Optional.ofNullable("Teste 5"));
    tests.add(Optional.ofNullable(null));

    // 1.2 e 1.4
    // for (Optional<String> t : tests) {
    //   t.ifPresentOrElse(System.out::println, () -> System.out.println("kakaka"));
    // }

    // 1.2 e 1.3
    // for (Optional<String> t : tests) {
    //   t.ifPresentOrElse(System.out::println, IllegalStateException::new);
    // }

    // 1.5
    // for (Optional<String> t : tests) {
    //   t.map(x -> x.replace("Teste", "Banana")).ifPresent(System.out::println);;
    // }

    // 1.4 e 1.6
    // for (Optional<String> t : tests) {
    //   String away = t.map(x -> x.toString()).orElse(null);
    //   System.out.println(away);
    // }

    // 1.4 e 1.7
    for (Optional<String> t : tests) {
      System.out.println(t.filter(x -> x.compareTo("Teste 4") < 0));
    }

    Optional<String> aaa = Optional.empty();
    aaa.get();
  }
}
