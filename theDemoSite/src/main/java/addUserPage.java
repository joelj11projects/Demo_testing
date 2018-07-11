import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addUserPage {

    @FindBy(name = "username")
    private WebElement addName;

    public void typeName(){
        addName.sendKeys("jjjj");
    }

    @FindBy(name = "password")
    private WebElement addPass;
    public void typePass(){
        addPass.sendKeys("1111");

    }

    @FindBy(name = "FormsButton2")
    private WebElement saveUser;
    public void clickSave(){
        saveUser.click();
    }
}
