package digital.innovation.one;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {
    @TempDir
    static Path tempDir;

    @BeforeAll
    static void beforeAll() {
        assertTrue(Files.isDirectory(tempDir));
    }

    @Test
    void shouldCreateNewFileWithTempDir() throws IOException {
        File testing = File.createTempFile("testing", ".txt", tempDir.toFile());

        assertTrue(testing.isFile());
        assertEquals(Path.of(testing.getAbsolutePath()).getParent(), tempDir);
    }
}
