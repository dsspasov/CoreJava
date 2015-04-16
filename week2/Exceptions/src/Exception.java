
public class Exception {
    public static void tryCatchFinally(){
        try{
            throw new RuntimeException();
        }catch(RuntimeException e){
            System.out.println("catch");
        }finally{
            System.out.println("finally");
        }
    }
    public static void main(String[] args) {
        
        tryCatchFinally();
        
        try{
            throw new Error("My error");
            
        }catch(Throwable e){
            System.out.println(e.getMessage());
        }
    }
}