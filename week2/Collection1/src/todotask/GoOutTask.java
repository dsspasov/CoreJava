package todotask;

public class GoOutTask extends Task {
    GoOutTask(){
        super();
    }
    
    GoOutTask(int priority){
        super(priority);
    }
    
    GoOutTask(float time){
        super(time);
    }
    
    GoOutTask(int priority, float time){
        super(priority, time);
    }
}