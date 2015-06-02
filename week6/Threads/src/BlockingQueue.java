//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//import java.util.Queue;

public class BlockingQueue {

    private LinkedList<Integer> queue = new LinkedList<Integer>();

    public void add(int element) {
        synchronized (this) {
            this.queue.add(element);
            notifyAll();
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int poll() throws InterruptedException {

        int result = 0;
        synchronized (this) {
            while (queue.isEmpty()) {
                wait();
            }
            if (!queue.isEmpty()) {
                result = queue.get(0);
                //queue.removeFirst();
            }
        }

        return result;
        // return 0;
    }
}
