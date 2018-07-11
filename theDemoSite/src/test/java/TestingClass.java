import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
import java.io.IOException;

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
    public void methodTest() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Constant.excelSheetLocation + Constant.excelSheet);
        } catch (FileNotFoundException e) {
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);

        } catch (IOException e) {

        }

        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Cell username = sheet.getRow(i).getCell(0);
            Cell password = sheet.getRow(i).getCell(1);
            String user = username.getStringCellValue();
            String pass = password.getStringCellValue();



            //XSSFCell cell = sheet.getRow(0).getCell(0);
            System.out.println(username.getStringCellValue());
            System.out.println(password.getStringCellValue());


            driver.manage().window().maximize();
            driver.get(Constant.theWebsite);
            landingPage page = PageFactory.initElements(driver, landingPage.class);
            page.addUser();

            addUserPage addUser = PageFactory.initElements(driver, addUserPage.class);
            addUser.typeName(user);
            addUser.typePass(pass);
            addUser.clickSave();

            LoginPage logUser = PageFactory.initElements(driver, LoginPage.class);
            logUser.clickLogin();
            logUser.typeName(user);
            logUser.typePass(pass);
            logUser.clickLogBtn();

            test = extent.startTest("Verify application");
            test.log(LogStatus.INFO, "Browser started");
            test.log(LogStatus.PASS, "verify title of the page");


            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }



}
