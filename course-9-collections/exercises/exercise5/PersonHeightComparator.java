package exercises.exercise5;

import java.util.Comparator;

public class PersonHeightComparator implements Comparator<Person> {

  @Override
  public int compare(Person o1, Person o2) {
    return o1.getHeight() - o2.getHeight();
  }
  
}
