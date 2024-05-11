package systemDesign.designPattern.creationalPatterns.builderPattern;

public class Student {

    int rollNo;
    String name;
    String address;


    public Student(BuilderStudent builderStudent) {
        this.rollNo = builderStudent.rollNo;
        this.name = builderStudent.name;
        this.address = builderStudent.address;
    }
}
