package Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import Service.POJOOutput;

import java.io.IOException;


public class TestDeckera {

    public POJOOutput[] pojoOutput;

    @Test
    public void test()
    {
        Response response=RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        System.out.println("Response of the API" +response.toString());
        Assert.assertEquals(response.getStatusCode(),200);
        ObjectMapper mapper=new ObjectMapper();
        try{
            pojoOutput=mapper.readValue(response.getBody().asString() ,POJOOutput[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(pojoOutput[0].getTitle(),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }
}
