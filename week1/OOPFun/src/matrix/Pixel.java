package matrix;

public class Pixel {
    private float R;
    private float G;
    private float B;
    
    Pixel(){
        this.R = 0;
        this.G = 0;
        this.B = 0;
    }
    
    Pixel(float red, float green, float blue){
        this.R = red;
        this.G = green;
        this.B = blue;
        
    }

    public float getR() {
        return R;
    }

    public void setR(float r) {
        R = r;
    }

    public float getG() {
        return G;
    }

    public void setG(float g) {
        G = g;
    }

    public float getB() {
        return B;
    }

    public void setB(float b) {
        B = b;
    }
    
    @Override
    public String toString(){
        return "|red = " + R + "green = " + G + "blue = " + B +"|";
    }
    
}
