package foolprooftimeclass;

public class Main {

    public static void main(String[] args){
        Time time = new Time(25,50,23,2,2,2002);
        System.out.println(time.toString());
        
        Time time1 = Time.now();
        System.out.println(time1.toString());
        
    }
}
