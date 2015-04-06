package todotask;

public class LearnGeometryTask extends Task{
    LearnGeometryTask(){
        super();
    }
    
    LearnGeometryTask(int priority){
        super(priority);
    }
    
    LearnGeometryTask(float time){
        super(time);
    }
    
    LearnGeometryTask(int priority, float time){
        super(priority, time);
    }
}