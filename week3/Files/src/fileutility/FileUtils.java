package fileutility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileUtils {

    private FileUtils() {
    }

    private static FileUtils instance = null;

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    /* 1. Prepare utility methods for reading and writing to files */

    public static String readFrom(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String currentLine;
        StringBuilder string = new StringBuilder();
        while ((currentLine = bf.readLine()) != null) {
            string.append(currentLine);
        }

        bf.close();
        return string.toString();
    }

    public static String readFrom(Path path) throws IOException {

        File file = path.toFile();
        return readFrom(file);
    }

    public static void writeTo(File file, String text) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
    }

    public static void writeTo(Path path, String text) throws IOException {
        File file = path.toFile();
        writeTo(file, text);

    }

    /* 2. Implement a 'Properties' file parser. */

    public Map<String, String> parseProperties(File propertyFile) throws IOException {
        FileReader fr = new FileReader(propertyFile);
        BufferedReader bf = new BufferedReader(fr);
        String currentLine;
        List<String> list = new LinkedList<String>();
        while ((currentLine = bf.readLine()) != null) {
            list.add(currentLine);
        }
        bf.close();
        return parseLogic(list);
    }

    public Map<String, String> parseLogic(List<String> list) {
        Map<String, String> map = new HashMap<String, String>();
        for (String line : list) {
            if (!line.startsWith("#")) {
                String key = line.substring(0, line.indexOf("=")).trim();
                String value = line.substring(line.indexOf("=")+1).trim();
                map.put(key, value);
            } else {
                continue;
            }
        }
        return map;
    }

    /* 4 */

    public static void fixEncoding(Path path) throws IOException {
        byte[] byteArr = Files.readAllBytes(path);
        byteArr = new String(byteArr, "Windows-1251").getBytes("UTF-8");
        Files.write(path, byteArr);
    }

    /* 5 */
    public Path reduceFilePath(Path path) {
        return path.normalize();
    }

    /* 6 */
    public static void findBrokenFiles(Path path) throws IOException {
        if (path.toFile().isDirectory()) {
            for (File children : path.toFile().listFiles()) {
                findBrokenFiles(children.toPath());
            }
        } else if ((Files.isSymbolicLink(path)) && !(Files.readSymbolicLink(path)).toFile().exists()) {
            System.out.printf("Broken Link: %s%n", path.toString());
        }

    }

    /* 7 */
    public static void compress(Path filePath) throws IOException {
        String text = readFrom(filePath);
        String[] arrayOfWords = text.split(" ");
        
        Map <String, Integer> mapOfWords = new HashMap<String, Integer>();
        int index = 0;
        for(String word: arrayOfWords){
            if(!mapOfWords.containsKey(word)){
                mapOfWords.put(word, index);
                index++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String word: arrayOfWords){
            String compressedWord = "~"+mapOfWords.get(word) + " ";
            sb.append(compressedWord);
        }
        sb.append("\nLegend:"+mapOfWords.toString());
        Path x = Paths.get("C:\\Users\\user\\Desktop\\Core-Java-2-master\\file.compr");
        writeTo(x, sb.toString());
        //System.out.println(sb.toString());
    }
    
   /* public static void decompress(Path filePath) throws IOException{
        String text = readFrom(filePath);
    }*/
}
