package textfile.lookup;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class FileContentTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
    this_file_does_not_exist.txt, 12, 0
    emptyFile.txt, 12, 0
    sumInput.txt, 12, 2
    """)
    public void contentLineCount(String filename, String content, int foundCount) {
        assertEquals(foundCount, FileContent.contentLineCount(filename, content));
    }

    @Test
    public void contentLineNumbers() {
        assertArrayEquals(new int[] {3,4}, FileContent.contentLineNumbers("sumInput.txt", "12"));
    }
}
