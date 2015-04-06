package statistics;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Statistics implements StatisticsInterface {

    public Map<Integer, Integer> statisticValues = new HashMap<Integer, Integer>();
    private List<Integer> listOfValues = new LinkedList<Integer>();
    private int sum = 0;

    Statistics() {
        super();
    }

    public static Statistics createInstance(){
        return new Statistics();
    }
    
    @Override
    public void add(int element) {
        this.listOfValues.add(element);
        if (statisticValues.containsKey(element)) {
            statisticValues.put(element, statisticValues.get(element) + 1);
        } else {
            statisticValues.put(element, 1);
        }
        Collections.sort(this.listOfValues);
        sum += element;
    }

    @Override
    public double getMean() {
        return Double.valueOf(sum)/ this.listOfValues.size();
    }

    @Override
    public double getMedian() {
        int length = this.listOfValues.size();
        if (length % 2 == 0) {
            int x =this.listOfValues.get(length / 2 -1);
            int y =this.listOfValues.get(length / 2);
            return Double.valueOf((x + y)) / 2;
        } else {
            return Double.valueOf(this.listOfValues.get(length / 2));
        }
    }

    @Override
    public List<Integer> getMode() {
        
        List<Integer> modes = new LinkedList<Integer>();
        int max = 0;
        for(Integer key: statisticValues.keySet()){
            if(max < statisticValues.get(key)){
                modes.clear();
                modes.add(key);
                max = statisticValues.get(key);
            }else if(max == statisticValues.get(key)){
                modes.add(key);
            }
        }
        return modes;
    }

    @Override
    public int getRange() {
        int length = this.listOfValues.size();
        return this.listOfValues.get(length-1) - this.listOfValues.get(0);
    }

    public static void main(String[] args){
        
        Statistics stat = Statistics.createInstance(); 
        stat.add(12);
        stat.add(13);
        stat.add(13);
        stat.add(13);
        stat.add(14);
        stat.add(14);
        stat.add(14);
        stat.add(16);
        stat.add(18); 
        stat.add(21);
        
        System.out.println(stat.getMean());
        System.out.println(stat.getMedian());
        System.out.println(stat.getMode());
        System.out.println(stat.getRange());
        System.out.println(stat.statisticValues.values().toString());
        System.out.println(stat.statisticValues.keySet().toString());
    }
}
