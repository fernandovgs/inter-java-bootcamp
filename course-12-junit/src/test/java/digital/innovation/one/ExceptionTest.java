package digital.innovation.one;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import java.lang.IndexOutOfBoundsException;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class ExceptionTest {
    @Test()
    void empty() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> toFail = new ArrayList<>();
            var toFailStr = toFail.get(0);
        });
    }

    @Test
    void textExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Index 0 out of bounds for length 0"));
        }
    }
}
