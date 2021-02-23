package digital.innovation.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertTest {
    @Test
    void testAssertArrayEquals() {
        byte[] expected = "test".getBytes();
        byte[] current = "test".getBytes();
        assertArrayEquals(expected, current);
    }

    @Test
    void testAssertEquals() {
        assertEquals("test", "test");
    }

    @Test
    void testAssertFalse() {
        assertFalse(false);
    }

    @Test
    void testAssertNotNull() {
        assertNotNull(new Object());
    }

    @Test
    void testAssertNotSame() {
        assertNotSame(new Object(), new Object());
    }

    @Test
    void testAssertSame() {
        Integer aNumber = Integer.valueOf(111);
        assertSame(aNumber, aNumber);
    }


}
