import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {

    private static Object monitor = new Object();
    static int counter = 0;
    static AtomicInteger atomicCounter = new AtomicInteger();
    private static boolean counting = false;

    public synchronized static void increment() {
        for (int i = 0; i < 2_000_000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread T1 = new Thread(new A());
        Thread T2 = new Thread(new B());

        // long startTime = System.currentTimeMillis();
        T1.start();
        T2.start();
        T1.join();
        // System.out.println("Time1:"+(System.currentTimeMillis() -
        // startTime));
        // System.out.println(counter);
        // startTime = System.currentTimeMillis();
        T2.join();
        // System.out.println("Time2:"+(System.currentTimeMillis() -
        // startTime));
        // System.out.println(counter);

    }

    private static class A implements Runnable {

        @Override
        public void run() {

            System.out.println("TreadA");
            synchronized (monitor) {
                while (!counting) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 2_000_000; i++) {
                    counter++;
                }
                System.out.println("A:" + counter);
            }
            /*
             * for (int i = 0; i < 2_000_000; i++) { counter++; }
             * System.out.println("A:" + counter);
             */
            /*
             * atomicCounter int i = 0; while (i < 2_000_000) {
             * atomicCounter.incrementAndGet(); i++; }
             */

            /*
             * synchronized method
             * 
             * increment();
             */

            /*
             * synchronized block synchronized (monitor) { for (int i = 0; i <
             * 2_000_000; i++) { counter++; } }
             */

            // System.out.println("A:" + atomicCounter.get());

            /*
             * System.out.println("A:" + counter);
             */
        }

    }

    private static class B implements Runnable {

        @Override
        public void run() {
            System.out.println("ThreadB");
            counting = true;

            synchronized (monitor) {

                for (int i = 0; i < 2_000_000; i++) {
                    counter++;
                }
                System.out.println("B:" + counter);
                monitor.notifyAll();
            }

            /*
             * atomicCounter int i = 0; while (i < 2_000_000) {
             * atomicCounter.incrementAndGet(); i++; }
             */

            /*
             * synchronized method increment();
             */

            /*
             * Synchronized block synchronized (monitor) { for (int i = 0; i <
             * 2_000_000; i++) { counter++; } }
             */
            /*
             * System.out.println("B:" + counter);
             */
            // System.out.println("B:" + atomicCounter.get());

        }

    }

}
