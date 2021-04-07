package Service;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class sampledata{

    @Test(priority = 0)
    public void execute()
    {
    Response response=RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Code is " +response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testException() {
        System.out.println("SoftwareTestingMaterial.com");
        int i = 1 / 0;
    }

    @Test
    @Parameters("browser")
    public void parameterizedTest(String browser){
        if(browser.equals("firefox")){
            System.out.println("Open Firefox Driver");
        }else if(browser.equals("chrome")){
            System.out.println("Open Chrome Driver");
        }
    }
    @Test(dependsOnMethods = {"testCase2"})
    public void testCase1(){
            System.out.println("Test Case 1");
        }


    @Test(threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
    public void testCase2(){
            System.out.println("Test Case 2");
        }


}
