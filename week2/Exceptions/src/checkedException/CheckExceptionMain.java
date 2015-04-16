package checkedException;

public class CheckExceptionMain {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (ServiceNotAvailableAtTheMomentException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void throwException() throws ServiceNotAvailableAtTheMomentException {
        throw new ServiceNotAvailableAtTheMomentException();
    }
 
}
