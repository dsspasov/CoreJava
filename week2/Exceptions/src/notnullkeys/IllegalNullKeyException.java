package notnullkeys;

public class IllegalNullKeyException extends IllegalArgumentException {
    
    
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private static final String DEFAULT_MESSAGE = "Null key is not allowed";
 //   @SuppressWarnings("unused")
    private String message;

    IllegalNullKeyException(){
        this(DEFAULT_MESSAGE);
    }
    
    IllegalNullKeyException(String message){
        this.message = message;
    }
    
    @Override
    public String getMessage(){
        return this.message;
    }
}
