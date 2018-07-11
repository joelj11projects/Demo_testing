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

    public void typeName(String user){
        addName.sendKeys(user);
    }

    @FindBy(name = "password")
    private WebElement addPass;
    public void typePass(String pass) {
        addPass.sendKeys(pass);
    }

    @FindBy(name = "FormsButton2")
    private WebElement loginUser;

    public void clickLogBtn(){
        loginUser.click();
    }


}
