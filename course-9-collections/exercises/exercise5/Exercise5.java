package exercises.exercise5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise5 {
  public static void main(String[] args) {
    List<Person> persons = new ArrayList<>();

    persons.add((new Person(5, "Anderson", 170)));
    persons.add((new Person(2, "Fernando", 183)));
    persons.add((new Person(4, "Zidane", 180)));
    persons.add((new Person(3, "Caio", 200)));
    persons.add((new Person(1, "Daniel", 168)));

    System.out.println(">> By name: <<");
    Collections.sort(persons, new PersonNameComparator());
    for (Person p : persons) {
      System.out.println(p);
    }

    System.out.println("\n\n>> By id: <<");
    Collections.sort(persons);
    for (Person p : persons) {
      System.out.println(p);
    }

    System.out.println("\n\n>> By height: <<");
    persons.sort((p1, p2) -> p1.getHeight() - p2.getHeight());
    for (Person p : persons) {
      System.out.println(p);
    }

    System.out.println("\n\n>> By id (static methods): <<");
    persons.sort(Comparator.comparingInt(Person::getId));
    for (Person p : persons) {
      System.out.println(p);
    }    
  }
}
