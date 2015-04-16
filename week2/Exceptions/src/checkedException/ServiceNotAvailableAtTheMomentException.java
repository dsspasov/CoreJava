package checkedException;

@SuppressWarnings("serial")
public class ServiceNotAvailableAtTheMomentException extends Exception{
    private String exceptionMessage;
    
    ServiceNotAvailableAtTheMomentException(){
        this.exceptionMessage = "Service is not available at the moment\n";
    }
    
    ServiceNotAvailableAtTheMomentException(String message){
        this.exceptionMessage = message;
    }
    
    @Override
    public String getMessage() { 
        return this.exceptionMessage;
    }

}
