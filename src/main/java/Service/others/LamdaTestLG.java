package Service.others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LamdaTestLG {

    WebDriver driver;
    @Test(priority =0)
    public void executeLG() {
        String name;
        String price;
        int intPrice;
        WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.chrome.driver", "/home/nirmeetikhandelwal/Downloads/chromedriver_linux64/chromedriver");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("lg washing machine");;
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> priceList = driver.findElements(By.xpath("//*[contains(@class,'a-price-whole')]"));
        List<WebElement> nameList =driver.findElements(By.xpath("//*[contains(@class,'a-size-medium') and contains(@class,'a-color-base') and contains(@class,'a-text-normal')]"));

        HashMap<Integer, String> h1 = new HashMap<Integer, String>();
        int i=0;
        int j=0;
        for(i=0,j=0;(i<priceList.size())&& (j<nameList.size());i++,j++)  //to fix Index out of Bound exception as some list have Null Price but have names
        {
            if(priceList.get(i).getText().isEmpty() || priceList.get(i).getText()==null) //to fix NumberFormatException in the ParseInt method in case of Empty or Null string.
                continue;
            name = nameList.get(j).getText();
            price = priceList.get(i).getText();
            price = price.replaceAll("[^0-9]", "");//regex to convert eg.14,990/- to 14990
            intPrice = Integer.parseInt(price);//String to Integer
            h1.put(intPrice, name); //Putting values in hashmap
        }
        ArrayList<Integer> arrayList_price = new ArrayList<Integer>(h1.keySet());//fetching keys and put into Arraylist
        Collections.sort(arrayList_price);  //sorting key in ascending order
        System.out.println("All products "+arrayList_price.size());

        for(int k=arrayList_price.size(); k >0;k--)
            System.out.println("Product Price is :" +arrayList_price.get(k-1) +"\t" +"Product Name :" +h1.get(arrayList_price.get(k-1)));
           driver.close();

    }
//
//    @Test(priority =2)
//    public void closeBrowser(){
//        driver.close();
//    }
}
