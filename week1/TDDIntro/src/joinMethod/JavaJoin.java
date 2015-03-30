package joinMethod;

public class JavaJoin {
    
    public  String join(Object... array){
        String glue = array[0].toString();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i<array.length; i++) {
            result.append(array[i].toString()+glue);
        }
        return result.toString().trim();
    }
}
