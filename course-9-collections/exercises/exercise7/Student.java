package exercises.exercise7;

public class Student {
  private Integer id;
  private String name;
  private Integer age;

  public Student() {

  }

  public Student(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getId() {
    return this.id;
  }
  public String getName() {
    return this.name;
  }
  public void setAge(Integer age) {
    this.age = age;
  }
  public Integer getAge() {
    return this.age;
  }

  @Override
  public String toString() {
    return String
      .format("Id: %d - Nome: %s - Idade: %d", this.getId(), this.getName(), this.getAge());
  }
}
