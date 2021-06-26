package Service;

import POJO.POJOOutput;

import java.util.Objects;

public class Notes {

    public static void main(String args[]) {
        POJOOutput pojoOutput = null;
        POJOOutput pojoOutput1=new POJOOutput();


        System.out.println(pojoOutput.getBody()); //Will throw null pointer
        System.out.println(pojoOutput1.getBody());//fine

    }
}
