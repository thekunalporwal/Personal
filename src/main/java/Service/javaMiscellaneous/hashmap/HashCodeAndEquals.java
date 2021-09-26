package Service.javaMiscellaneous.hashmap;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class HashCodeAndEquals {

    String name;
    Integer id;

    HashCodeAndEquals(int id ,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj){

        if(this==obj)
            return true;

        HashCodeAndEquals h1=(HashCodeAndEquals) obj;
        if(h1.getName()==this.getName())
           return true;
        else
            return false;

    }

    @Override
    public int hashCode(){
        return this.id;
    }


    public static void main(String args[]){
        HashCodeAndEquals h1=new HashCodeAndEquals(1,"name");
        HashCodeAndEquals h2=new HashCodeAndEquals(2,"surname");

        if(h1.hashCode()!=h2.hashCode())
            System.out.println("true" + h1.hashCode() +" " +h2.hashCode());

        if(h1.equals(h2))
            System.out.println("equal object");

    }


}
