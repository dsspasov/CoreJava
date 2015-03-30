package cars;
public class Car {
    private String type;
    private int mileage;

    public Car() {
        this.type = "";
        this.mileage = 0;
    }

    public Car(String type, int mileage) {
        this.type = type;
        if (mileage > 0) {
            this.mileage = mileage;
        } else {
            this.mileage = 0;
        }
    }
    public String getType(){
        return this.type;
    }
    
    public int getMileage(){
        return this.mileage;
    }
    
    @Override
    public String toString(){
        return this.type + "--" + this.mileage;
    }
}
