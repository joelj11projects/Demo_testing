import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class landingPage {

    @FindBy (xpath = Constant.addUserLink)
    private WebElement detailsCheck;

    public void addUser() {
        detailsCheck.click();
    }


}
