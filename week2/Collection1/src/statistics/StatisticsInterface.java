package statistics;

import java.util.List;

public interface StatisticsInterface {
    
    void add(int element);
    double getMean();
    double getMedian();
    List<Integer> getMode();
    int getRange();
    
}
