import java.lang.annotation.Annotation;
//import java.lang.reflect.AnnotatedElement;



@ClassInfo(author = "bau bau", relatedClasses = {String.class,Double.class})
public class ClassTest {

    
    public static void main(String[] args) {
        
        Annotation[] annotations = ClassTest.class.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation.annotationType().getName());
        }
                
        ClassTest test = new ClassTest();
        Annotation annotation =   test.getClass().getAnnotation(ClassInfo.class);
        
        if (annotation instanceof ClassInfo){
            ClassInfo myAnnotation = (ClassInfo)annotation;
          
            
            System.out.print("author: " + myAnnotation.author());
            System.out.print(", class reservation: " + myAnnotation.classRevison());
            System.out.print(", checked: " + myAnnotation.checked());
            System.out.print(", classRevison: " + myAnnotation.relatedClasses()[0]);

        }
                
        //System.out.println(test.getClass().getAnnotations());
    }
}
