package fileutility;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        //FileUtils x = FileUtils.getInstance();
       /* Path path = Paths.get("C:\\Users\\user\\Desktop\\Core-Java-2-master\\lost.s04e11.hdtv.xvid-2hd.srt");
        try{
            FileUtils.fixEncoding(path);
        }catch(IOException e){
            e.printStackTrace();
        }
        */
        
        Path path = Paths.get("C:\\Users\\user\\Desktop\\Core-Java-2-master\\file.txt");
        try{
            FileUtils.compress(path);
        }catch(IOException e){
            e.printStackTrace();
        }
        /*
        Path path = Paths.get("C:\\Users\\user\\Desktop\\Core-Java-2-master\\test.txt");
        try {
            System.out.println(x.parseProperties(path.toFile()));
            System.out.println(x.parseProperties(path.toFile()).get("a7"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
        
    }

}
