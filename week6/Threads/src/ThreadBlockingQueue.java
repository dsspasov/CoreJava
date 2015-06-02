
public class ThreadBlockingQueue {
    
    private static BlockingQueue x = new BlockingQueue();
    public static void main(String[] args) throws InterruptedException {
        
        //x.add(2);
        //System.out.println(x.isEmpty());
        //System.out.println(x.poll());
        Thread T1 = new Thread(new AThread());
        Thread T2 = new Thread(new BThread());
        T1.start();
        //T1.join();
        T2.start();
        //T2.join();
        //System.out.println(x.poll());
        /*System.out.println(x.poll());
        System.out.println(x.poll());*/
    }
   
    
    
    static class AThread implements Runnable{

        @Override
        public void run() {
           System.out.println("adding...");
           x.add(1);
           x.add(2);
           x.add(3);
           x.add(4);
        }
        
        
    }

    static class BThread implements Runnable{

        @Override
        public void run() {
           try {
            System.out.println("polling...");
            System.out.println(x.poll());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
        }
    
        
    }


}

