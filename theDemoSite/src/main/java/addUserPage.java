import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addUserPage {

    @FindBy(name = "username")
    private WebElement addName;
    @FindBy(name = "password")
    private WebElement addPass;

    @FindBy(name = "FormsButton2")
    private WebElement saveUser;


    public void typeName(String user){

        addName.sendKeys(user);
    }


    public void typePass(String pass ){
        addPass.sendKeys(pass);

    }

    public void clickSave(){
        saveUser.click();
    }
}
