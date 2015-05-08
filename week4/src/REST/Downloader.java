package REST;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {

    public static void download(String link) throws MalformedURLException, IOException, InterruptedException {
        URL url = new URL(link);
        String fileName = link.substring(link.lastIndexOf("/") + 1, link.length());
        
        InputStream is = new BufferedInputStream(url.openStream());
        FileOutputStream out = new FileOutputStream(fileName);
        
        byte[] arr = new byte[1024];
        
        int numberOfBytes = 0;
        
        System.out.println("Downloading " + fileName);
        
        Thread.sleep(2000);
        
        while((numberOfBytes=is.read(arr))!=-1){
            out.write(arr, 0, numberOfBytes);
        }
        
        Thread.sleep(1000);
        System.out.println("Downloading of " + fileName +" is complete!");
        is.close();
        out.close();
        
       // System.out.println(fileName);

    }

    public static void main(String[] args) {
        try {
            download("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
