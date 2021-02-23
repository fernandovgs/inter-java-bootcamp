package digital.innovation.one;

import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
import org.hamcrest.object.HasToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;


public class MatcherTest {
    @Test
    void checkToString() {
        Person person = new Person("Fernando", "Gianini");
        String strPerson = person.toString();
        assertThat(person, HasToString.hasToString(strPerson));
    }

    @Test
    void checkIfPropertyExists() {
        Person person = new Person("Fernando", "Gianini");
        assertThat(person, HasProperty.hasProperty("name"));
    }

    @Test
    void checkEmpty() {
        List<String> empty = new ArrayList<>();
        assertThat(empty, Matchers.empty());
    }

    @Test
    void checkGreater() {
        assertThat(1, Matchers.greaterThan(0));
    }

    @Test
    void checkNull() {
        String str = null;
        assertThat(str, Matchers.nullValue());
    }
}
