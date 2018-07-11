import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (xpath = Constant.loginLink)
    private WebElement loginPage;

    public void clickLogin(){
        loginPage.click();
    }

    @FindBy(name = "username")
    private WebElement addName;

    public void typeName(){
        addName.sendKeys("jjjj");
    }

    @FindBy(name = "password")
    private WebElement addPass;
    public void typePass() {
        addPass.sendKeys("1111");
    }

    @FindBy(name = "FormsButton2")
    private WebElement loginUser;

    public void clickLogBtn(){
        loginUser.click();
    }


}
