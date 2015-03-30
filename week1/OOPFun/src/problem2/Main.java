package problem2;

public class Main {

    public static void main(String[] args){
        Time time = new Time(23,50,10,2,2,2002);
        System.out.println(time.toString());
        
        Time time1 = Time.now();
        System.out.println(time1.toString());
        
    }
}
