package Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import Service.POJOOutput;

import java.io.IOException;


public class TestDeckera {

    public POJOOutput[] pojoOutput;
    public POJOOutput pojoOutput2 ;

    @Test  //Get Request of Array of Json Objects
    public void test1() throws JSONException {

        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
        RequestSpecification request=RestAssured.given();
        Response response=request.get("/posts");
        System.out.println("Response of the API" +response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);
        ObjectMapper mapper=new ObjectMapper();
        try{
            pojoOutput=mapper.readValue(response.getBody().asString() ,POJOOutput[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(pojoOutput[0].getTitle(),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Test //Get Request of simple Json Response
    public void test2() throws JSONException {

        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
        RequestSpecification request=RestAssured.given();
        Response response=request.get("/posts/1");
        System.out.println("Response of the API" +response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);
        ObjectMapper mapper=new ObjectMapper();
        try{
            pojoOutput2=mapper.readValue(response.getBody().asString() ,POJOOutput.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(pojoOutput2.getTitle(),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Test    //Without Body Post Request
    public void test3() throws JSONException {

        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
        RequestSpecification request=RestAssured.given();
        request.contentType("application/json");


        Response response=request.post("/posts");
        System.out.println("Response of the API" +response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),201);


        ObjectMapper mapper=new ObjectMapper();
        try{
            pojoOutput2=mapper.readValue(response.getBody().asString() ,POJOOutput.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(pojoOutput2.getId(),101);
        //Response Headers
        System.out.println(response.getHeaders().get("Content-Length").toString());
    }

    @Test //With Body and Headers Post Request
    public void test4() throws JSONException {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification request =RestAssured.given();
        request.contentType("application/json");

        JSONObject  payload = new JSONObject();
        payload.put("title","foo");
        payload.put("body","bar");
        payload.put("userId","1");
        request.body(payload.toString());
        Response response=request.post("/posts");


        System.out.println("Response of the API" +response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),201);

        ObjectMapper mapper = new ObjectMapper();
        try {
            pojoOutput2 = mapper.readValue(response.getBody().asString(), POJOOutput.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(pojoOutput2.getId(),101);
        Assert.assertEquals(pojoOutput2.getTitle(),"foo");
        Assert.assertEquals(pojoOutput2.getBody(),"bar");
    }



}
