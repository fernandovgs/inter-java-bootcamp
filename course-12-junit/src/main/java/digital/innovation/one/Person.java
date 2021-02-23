package digital.innovation.one;

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.surname);
    }
}
