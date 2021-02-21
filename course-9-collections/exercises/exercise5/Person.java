package exercises.exercise5;

public class Person implements Comparable<Person> {
  
  private Integer id;
  private String name;
  private Integer height;

  public Person() {
    this.id = null;
    this.name = null;
    this.height = null;
  }

  public Person(Integer id, String name, Integer height) {
    this.id = id;
    this.name = name;
    this.height = height;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getId() {
    return this.id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  public void setHeight(Integer height) {
    this.height = height;
  }
  public Integer getHeight() {
    return this.height;
  }

  @Override
  public int compareTo(Person o) {
    return this.id - o.id;
  }

  @Override
  public String toString() {
    return String.format("%d / %s / %dcm", this.getId(), this.getName(), this.getHeight());
  }
}
