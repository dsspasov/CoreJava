import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;

import com.nitido.utils.toaster.Toaster;


public class JToaster {

    public static void main(String[] args) throws InterruptedException, IOException {
        File f = new File("C:\\Users\\user\\Desktop\\azbW3zq_460sa_v1.gif");
        Image x = ImageIO.read(f);
        
        
        Toaster toasterManager = new Toaster();
        toasterManager.setToasterHeight(700);
        toasterManager.setToasterWidth(700);
        toasterManager.setBackgroundImage(x);
        //toasterManager.setStepTime(5);
        int i =0;
        while(i<3){
            
            //toasterManager.setDisplayTime(1000);
            i++;
            toasterManager.showToaster("A simple toaster with an image" );
            Thread.sleep(5000);
        }
        
        
        

        
        
    }
}
