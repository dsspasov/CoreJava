package Database;

import java.util.LinkedList;
import java.util.List;


public class Database {

    private List<User> users;
    
    public Database(){
        users = new LinkedList<User>();
        
        try{
            this.users.add(new User("Bai Ivan", "123456"));
            this.users.add(new User("Bai Ivan1", "123456"));
            this.users.add(new User("Bai Ivan2", "123456"));
            //this.users.add(new User("", "123456"));
            
        }catch(DatabaseCorruptedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }
    
    }
    public void add(User user){
        try{
            this.users.add(user);
        }catch(DatabaseCorruptedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
