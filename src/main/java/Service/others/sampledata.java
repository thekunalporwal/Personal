package Service.others;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class sampledata{
//
//    @Test(priority = 0)
//    public void execute()
//    {
//    Response response=RestAssured.get("https://reqres.in/api/users?page=2");
//        System.out.println("Code is " +response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(),200);
//    }
//
//    @Test(expectedExceptions = ArithmeticException.class)
//    public void testException() {
//        System.out.println("SoftwareTestingMaterial.com");
//        int i = 1 / 0;
//    }
//
//    @Test
//    @Parameters("browser")
//    public void parameterizedTest(String browser){
//        if(browser.equals("firefox")){
//            System.out.println("Open Firefox Driver");
//        }else if(browser.equals("chrome")){
//            System.out.println("Open Chrome Driver");
//        }
//    }
//    @Test(dependsOnMethods = {"testCase2"})
//    public void testCase1(){
//            System.out.println("Test Case 1");
//        }
//
//
//    @Test(threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
//    public void testCase2(){
//            System.out.println("Test Case 2");
//        }
//
//    @Test (enabled=false)
//    public void printClass2(){
//        System.out.println("This is Test Case 2");
//    }
//
//    @Test
//    public void aSkipTest(){
//        String a ="Skip Test";
//        if(a.equals("Skip Test")){
//            throw new SkipException("Skipping - This is not ready for testing ");
//        }else{
//            System.out.println("I am in else condition");
//        }
//        System.out.println("I am out of the if else condition");
//    }

    public static void main (String [] args) throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/kunalgupta/Downloads/Data Dictionary-BOSS.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        System.out.println(workbook.getNumberOfSheets());
        XSSFSheet sheet = workbook.getSheetAt(2);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);
//        System.out.println(sheet.getRow(0).getCell(0));
        //String cellval = cell.getStringCellValue();
        //System.out.println(cellval);
    }

}
