package exercises.exercise7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise7 {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();

    students.add(new Student(9, "Ana", 20));
    students.add(new Student(7, "Márcia", 17));
    students.add(new Student(4, "Fudêncio", 23));
    students.add(new Student(2, "Skyler Tadinha", 18));
    students.add(new Student(1, "Fernando", 27));
    students.add(new Student(5, "Picachu", 25));
    students.add(new Student(8, "André", 40));
    students.add(new Student(6, "Jô Soares", 16));
    students.add(new Student(10, "Jiraya", 40));
    students.add(new Student(3, "Basteras", 24));

    // A
    students.stream().map(t -> t.toString()).forEach(System.out::println);
    
    // B
    System.out.println(String.format("\n\nCount elements: %d", students.stream().count()));
    
    // C
    System.out.println("\n\nFilter students with age equal or above 18:");
    students.stream().filter(e -> e.getAge() >= 18).forEach(System.out::println);

    // D: kinda implicit on the other exercises

    // E
    System.out.println("\n\nFilter students with letter B in name");
    students.stream().filter(e -> e.getName().toLowerCase().contains("b")).forEach(System.out::println);

    System.out.println("\n\nFind if exists at least one dude with letter D in name: " + students
      .stream()
      .anyMatch(e -> e.getName().toLowerCase().equals("d")));

    // G
    System.out.println("\n\nStudent with highest age: " + students
      .stream().max(Comparator.comparingInt(e -> e.getAge())).get());
  }
}
