package systemDesign.designPattern.creationalPatterns.factoryMethod;

/**
 * Factory Method Pattern allows the subclasses to choose the type of objects to create.
 * Can't initialize the object of abstract class.
 * It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code.
 * That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.
 */
public abstract class PlanAbstractClass {

    //Constructor default call
    PlanAbstractClass(){
        System.out.println("PlanAbstractClass constructor");
    }
    protected double rate;
    public abstract double getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}
