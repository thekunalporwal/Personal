package systemDesign.designPattern.creationalPatterns.prototype;



/**
 Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.
 This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
 */
public class EmployeePrototype implements Prototype{

    private int id;
    private String name, designation;
    private double salary;
    private String address;

    EmployeePrototype(){
    }

    EmployeePrototype(int id, String name, String designation, double salary, String address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public Prototype getClone() {
        return new EmployeePrototype(id,name,designation,salary,address);
    }
}
