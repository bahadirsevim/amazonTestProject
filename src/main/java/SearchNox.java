import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchNox extends BasePage{

    By searchBoxLocator = By.id("twotabsearchtextbox");
    By submitButtonLocator = By.id("nav-search-submit-button");

    public SearchNox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        // wait(searchBoxLocator);
        type(searchBoxLocator, text);
        click(submitButtonLocator);
    }
}
