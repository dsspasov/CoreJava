import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)


public @interface ClassInfo {
    
    public String author();
    public int classRevison() default 1;
    public boolean checked() default true;
    public Class<?>[] relatedClasses();
    

}
