import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class JUnitClass {
    
    public static void assertTrueTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
        alabala x = new alabala();
        
        
       // Annotation[] annotations = alabala.class.getAnnotations();
        Method[] methods = alabala.class.getMethods();
        for(Method method : methods){
            Annotation[] annotations = method.getAnnotations();
            for(Annotation annotation: annotations){
                
                //System.out.println(annotation.toString());
                if(annotation.annotationType().getSimpleName().equals("Test")){
                    System.out.println("hi");
                    TestSuite returnValue = (TestSuite) method.invoke(null, null);
                    
                    TestRunner.run(returnValue);
                    //System.out.println(returnValue);
                }
            }
            
            
        }
                
       // Method testMethod = class.getMethod(, arg1);
       // return true;
    }
    
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //System.out.println("cascas");
        assertTrueTest();
    }
    
    
    
}
