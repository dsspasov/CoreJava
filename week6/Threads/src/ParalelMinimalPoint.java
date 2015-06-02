import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParalelMinimalPoint {

    //static List<Double> points = new ArrayList<Double>();

    public static List<Double> generatePoints() {
        List<Double> points = new ArrayList<Double>();
        for (int i = 0; i < 100; i++) {
            points.add(Math.random() * 10_000);
        }
        return points;
    }

    public static void doCalculations(List<Double> inPoints, int indexFrom, int indexTo, Map<Double, Double> outMap) {
        Double[] array = new Double[inPoints.size()];
        inPoints.toArray(array);
        Arrays.sort(array);
        int length = array.length;
        outMap.put(array[0], array[1]);
        outMap.put(array[length - 1], array[length - 2]);
        for (int i = 1; i < length - 1; i++) {
            if ((array[i] - array[i - 1]) > (array[i + 1] - array[i])) {
                outMap.put(array[i], array[i + 1]);
            } else {
                outMap.put(array[i], array[i - 1]);
            }
        }
    }

    public static Map<Double, Double> getNearestPoints(List<Double> generatedPoints) {
        final Map<Double, Double> map = Collections.synchronizedMap(new HashMap<Double, Double>());

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                doCalculations(generatedPoints, 0, generatedPoints.size() / 2, map);
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                doCalculations(generatedPoints, generatedPoints.size() / 2, (2 * generatedPoints.size()) / 2, map);

            }
        });

        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static void main(String[] args) {
        //generatePoints();
        Map<Double, Double> x = getNearestPoints(generatePoints());
        System.out.println(x);
    }
}
