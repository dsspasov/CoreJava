package filePath;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class FilePathTest {

    FilePath test = new FilePath();

    @Test
    public void testReduceFilePathWithEmptyString() {
        assertEquals("/", test.reduceFilePath(""));
    }

    @Test
    public void testReduceFilePathWithOneSlash() {
        String input = "/";
        String expectedOutput = "/";
        assertEquals(expectedOutput, test.reduceFilePath(input));
    }

    @Test
    public void testReduceFilePathOnlyWihSlashes() {
        String input = "////////////";
        String expectedOutput = "/";
        assertEquals(expectedOutput, test.reduceFilePath(input));
    }

    @Test
    public void testReduceFilePathOneDirectoryBack() {
        String input = "/../";
        String expectedOutput = "/";
        assertEquals(expectedOutput, test.reduceFilePath(input));

    }

    @Test
    public void testReduceFilePathOneDirectoryBackWithLotsOfFoleders() {
        String input = "/etc1/../etc2/../etc3/../etc4/../etc5/../etc6/../";
        String expectedOutput = "/";
        assertEquals(expectedOutput, test.reduceFilePath(input));
    }

    @Test
    public void testReduceFilePathAndStayInTheSameDir() {
        String input = "/srv/./././././";
        String expectedOutput = "/srv";
        assertEquals(expectedOutput, test.reduceFilePath(input));

    }

    @Test
    public void testReduceFilePathWithTwoSlashes() {
        String input = "/etc//wtf";
        String expectedOutput = "/etc/wtf";
        assertEquals(expectedOutput, test.reduceFilePath(input));
    }

    @Test
    public void testReduceFilePathAlreadyReduces() {
        String input = "/srv/www/htdocs/wtf";
        String expectedOutput = "/srv/www/htdocs/wtf";
        assertEquals(expectedOutput, test.reduceFilePath(input));

    }

}
