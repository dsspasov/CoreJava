package todotask;

public class Task implements Comparable<Task>{

    protected int priority;
    protected float time;
    protected boolean finished;

    public Task() {
        priority = 5;
        time = 1;
        finished = false;
    }

    public Task(int priority){
        this.priority = priority;
        this.time = 1;
        this.finished = false;
    }
    
    public Task(float time){
        this.priority = 5;
        this.time = time;
        this.finished = false;
    }
    
    public Task(int priority, float timeToFinish) {
        this.priority = priority;
        this.time = timeToFinish;
        this.finished = false;
    }

    public float getTime() {
        return this.time;
    }

    public int getPriority() {
        return this.priority;
    }
    
    public void setFinished(boolean f){
        this.finished = f;
    }
    
    public boolean getFinished(){
        return this.finished;
    }

    @Override
    public int compareTo(Task task) {
        return -this.priority + task.priority;
    }
}