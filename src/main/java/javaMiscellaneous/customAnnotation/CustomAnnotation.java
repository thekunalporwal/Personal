package javaMiscellaneous.customAnnotation;

import java.lang.annotation.*;

//@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface CustomAnnotation {
    String name() default "";
    int number();
//    String[] names();
}
