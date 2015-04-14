package todotask;

import java.util.PriorityQueue;

public class ToDoList {

    PriorityQueue<Task> queue = new PriorityQueue<Task>();
    private float hours;

    ToDoList(float hours) {
        this.setHours(hours);
    }

    void addTask(Task t) {
        queue.offer(t);
    }

    void markFinished(Task t) {
        if (!t.getFinished()) {
            t.setFinished(true);
        }
    }

    void markCancelled(Task t) {
        t.setFinished(false);
        this.queue.remove(t);

    }

    Task getTop() {
        return this.queue.peek();
        //return this.queue.element();
    }
    
    String top(){
        return getTop().getClass().getName().substring(9);
    }

    boolean canFinish() {
        return 0 <= getRemainigTime();
    }

    float getRemainigTime() {
        return (hours - getTimeNeeded());
    }

    float getTimeNeeded() {
        float timeNeeded = 0;
        for (Task t : queue) {
            timeNeeded += t.getTime();
        }
        return timeNeeded;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }
}