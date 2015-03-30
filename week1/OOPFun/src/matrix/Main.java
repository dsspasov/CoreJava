package matrix;

public class Main {
    public static void main(String[] args){
        Matrix x = new Matrix(5, 5);
        Pixel p = new Pixel(0.5f,1.5f,2.0f);
        x.fillMatrixWith(p);
        
        BrightnessReducer br = new BrightnessReducer();
        MatrixOperation obj = (MatrixOperation)br;
        x.operate(obj);
        System.out.println(x.toString());

    }
    
}
