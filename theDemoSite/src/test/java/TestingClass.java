import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestingClass {

    WebDriver driver;
    ExtentReports extent = new
            ExtentReports("C:/Users/Admin/Desktop/Report.html", true);
    ExtentTest test;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown(){

        driver.quit();
        extent.endTest(test);
        extent.flush();
    }

    @Test
    public void methodTest(){
        driver.manage().window().maximize();
        driver.get(Constant.theWebsite);
        landingPage page = PageFactory.initElements(driver,landingPage.class);
        page.addUser();

        addUserPage addUser = PageFactory.initElements(driver,addUserPage.class);
        addUser.typeName();
        addUser.typePass();
        addUser.clickSave();

        LoginPage logUser = PageFactory.initElements(driver,LoginPage.class);
        logUser.clickLogin();
        logUser.typeName();
        logUser.typePass();
        logUser.clickLogBtn();

        test = extent.startTest("Verify application");
        test.log(LogStatus.INFO, "Browser started");
        test.log(LogStatus.PASS, "verify title of the page");

        FileInputStream file = null;
        try {
            file = new FileInputStream(Constant.excelSheetLocation + Constant.excelSheet);
        } catch (FileNotFoundException e) {}
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);

        }


        try{
            Thread.sleep(3000);
        } catch(Exception e){
            System.out.println(e);}
    }




}
