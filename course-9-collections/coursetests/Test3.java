package coursetests;

import java.util.TreeSet;

public class Test3 {
  public static void main (String [] args) {
    TreeSet<String> teste = new TreeSet<>();

    teste.add("Porto Alegre");
    teste.add("Florianópolis");
    teste.add("Curitiba");
    teste.add("São Paulo");
    teste.add("Rio de Janeiro");

    teste.higher("Florianópolis");

    System.out.println(teste.lower("Florianópolis"));
  }
}