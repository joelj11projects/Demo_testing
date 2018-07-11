import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Testing {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void methodTest(){
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        HomePage typeInBox = PageFactory.initElements(driver,HomePage.class);
        typeInBox.typeSearchBox();



        try{
            Thread.sleep(3000);
        } catch(Exception e){
            System.out.println(e);}

    }

}
