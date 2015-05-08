package wordcount;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import junit.framework.Assert;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordCountResultTest {

    private Path path;
    private WordCountResult x;

    @Before
    public void setUp() {

        String text = "baba baba baba dqdo";
        
        this.path = Paths.get("C:\\Users\\user\\Desktop\\test.txt");
        File file = path.toFile();
        FileWriter fw;
        
        try {
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        x = new WordCountResult(path.toFile());

        try {
            x.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLineCount() {
        assertEquals(x.getLineCount(), 1);
    }

    @Test
    public void testGetWordCount() {
        assertEquals(x.getWordCount(), 4);
    }

    @Test
    public void testGetCharacterCount() {
        assertEquals(x.getCharacterCount(), 19);
    }

}
