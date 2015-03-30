package matrix;

public class BrightnessReducer implements MatrixOperation {

    private float brightnessFactor;
    BrightnessReducer(){
        super();
        brightnessFactor = 0.75f;
    }
    
    BrightnessReducer(float factor){
        super();
        brightnessFactor = factor;
    }
    
    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {        
        float red = matrix[x][y].getR()*brightnessFactor;
        float green = matrix[x][y].getG()*brightnessFactor;
        float blue = matrix[x][y].getB()*brightnessFactor;
        return new Pixel(red, green, blue);
    }

}
