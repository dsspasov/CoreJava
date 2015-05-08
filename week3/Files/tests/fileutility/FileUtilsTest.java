package fileutility;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileUtilsTest {

    private HashMap<String, String> map;
    private Path path;

    @Before
    public void setUp() throws Exception {
        path = Paths.get("C:\\Users\\user\\Desktop\\test.txt");
        File file = path.toFile();
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write("# this=comment");
            bf.newLine();
            bf.write("a1=b1");
            bf.newLine();
            bf.write("a2 =b2");
            bf.newLine();
            bf.write("a3    =    b3");
            bf.newLine();
            bf.write("a4 = b4");
            bf.newLine();
            bf.write("a5=b6=b7=b8");
            bf.newLine();
            bf.write("a6=b9 #comment");
            bf.newLine();
            bf.write("a7==b10");
            bf.newLine();

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        map = new HashMap<String, String>();
        map.put("a1", "b1");
        map.put("a2", "b2");
        map.put("a3", "b3");
        map.put("a4", "b4");
        map.put("a5", "b6=b7=b8");
        map.put("a6", "b9 #comment");
        map.put("a7", "=b10");
        
        
    }

    @After
    public void tearDown() throws Exception {
        Files.delete(path);
    }

    @Test
    public void testParseProperties() throws IOException {
        FileUtils x = FileUtils.getInstance();
        //try {
            //assertEquals(1,1);
            assertEquals(x.parseProperties(path.toFile()).keySet(), map.keySet());
            assertEquals(x.parseProperties(path.toFile()).values().toString(), map.values().toString());
            
        //} catch (IOException e) {
         //  e.printStackTrace();
        //}
    }

    @Test
    public void testReduceFilePath() {
        FileUtils x = FileUtils.getInstance();

        Path path = Paths.get("C:\\Users\\user\\Desktop\\.\\.\\.\\..\\ Desktop\\babab");
        assertEquals(x.reduceFilePath(path), path.normalize());

    }

}
