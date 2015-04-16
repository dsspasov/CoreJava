package Database;


public class Main {
    public static void main(String[] args) {
        Database bd = new Database();;
        try{
             bd.add(new User("gg","easy"));
             bd.add(new User("", "rekt"));
        }catch(DatabaseCorruptedException e){
            System.out.println(e.getMessage());
        
        }
        
    
    }
}
