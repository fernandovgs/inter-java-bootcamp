import java.util.function.Supplier;

public class Suppliers {
  public static void main(String[] args) {
    Supplier<Person> personInstance = Person::new;
    
    System.out.println(personInstance.get());
  }
}

class Person {
  private String name;

  private Integer age;

  public Person() {
    this.name = "Fernando";
    this.age = 25;
  }

  @Override
  public String toString() {
    return String.format("%s - %d anos", this.name, this.age);
  }
}