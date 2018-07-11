import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id="search_query_top")
    private WebElement searchBox;

    public void typeSearchBox(){
        searchBox.sendKeys("dress");
        searchBox.submit();

    }



}
