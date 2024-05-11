package systemDesign.designPattern.creationalPatterns.builderPattern;

import java.util.List;

public class BuilderStudent {

    int rollNo;
    String name;
    String address;

    List<String> subjects;

    public static BuilderStudent newInstance()
    {
        return new BuilderStudent();
    }
    private BuilderStudent() {}
    public BuilderStudent setRollNo(int rollNo) {
        this.rollNo = rollNo;
        return this;
    }
    public BuilderStudent setName(String name) {
        this.name = name;
        return this;
    }
    public BuilderStudent setAddress(String address) {
        this.address = address;
        return this;
    }

    public Student build() {
        return new Student(this);
    }

}
