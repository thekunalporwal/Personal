package systemDesign.designPattern.creationalPatterns.builderPattern;

import lombok.Getter;

@Getter
public class BuilderClassInitializer {

    private Student student;

    public BuilderClassInitializer() {

        Student student2= BuilderStudent.newInstance().setRollNo(123).setName("X").setAddress("Y").build();
        System.out.println(student2.rollNo);

//        Thread t1=new Thread(() ->
                student= BuilderStudent.newInstance().setRollNo(1).setName("A").setAddress("B").build();


//        Thread t2=new Thread(() -> student= BuilderStudent.newInstance().setRollNo(2).setName("C").setAddress("D").build());

//        t1.start();
//        t2.start();
    }

    public static void main(String args[]) {
        BuilderClassInitializer sr = new BuilderClassInitializer();
        System.out.println(sr.getStudent().rollNo);
    }

}
