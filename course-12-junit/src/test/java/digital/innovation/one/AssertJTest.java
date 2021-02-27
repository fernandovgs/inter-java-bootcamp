package digital.innovation.one;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {
    @Test
    void checkEquality() {
        Person person = new Person("Fernando", "Gianini");
        Person same = person;
        assertThat(person).isEqualTo(same);
    }
}
