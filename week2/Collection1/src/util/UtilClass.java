package util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UtilClass {

    private static final int DEFAULT_OCCURENCE = 1;
    static String convertHashMap(HashMap<? extends Object, ? extends Object> map){
        StringBuilder string = new StringBuilder();
        string.append("{ ");
        for(Entry<? extends Object, ? extends Object> e  : map.entrySet()){
           string.append(e.getKey()+":"+e.getValue()+", ");
        }
        string.delete(string.length()-2, string.length());
        string.append(" }");
        return string.toString();
    }
    
    static Map<String, Integer> countWord(String text){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        String[] arrayOfWords = text.split(" ");
        
        
        for(String word:arrayOfWords){
            if(map.containsKey(word)){
                int count = map.get(word);
                map.put(word, count+1);
            }else{
                map.put(word, DEFAULT_OCCURENCE);
            }
        }
        
        return map;
    }
    
    public static void main(String[] args) {
        /*HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        String result = UtilClass.convertHashMap(map);
        System.out.println(result);
        */
        Map<String, Integer> result = UtilClass.countWord("Ninjas are all over the place! We are all going to die!");
        System.out.println(result);

    }
}