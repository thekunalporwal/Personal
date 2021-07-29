package Service.javaMiscellaneous.customAnnotation;



@CustomAnnotation(number = 123)
public class CustomAnnotationExample {

    @CustomAnnotation(number = 1)
    public CustomAnnotationExample(){
       System.out.println("inside");
    }
}
