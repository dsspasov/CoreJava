package todotask;

public class SleepTask extends Task{    
    SleepTask(){
        this(8f);
    }
    
    SleepTask(int priority){
        super(priority);
    }
    
    SleepTask(float time){
        super(time);
    }
    
    SleepTask(int priority, float time){
        super(priority, time);
    }

}
