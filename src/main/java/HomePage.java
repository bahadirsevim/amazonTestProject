import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    SearchNox searchBox;
    By cartCountLocator = By.id("nav-cart-count");
    By cartContainerLocator = By.id("nav-cart-count-container");
    By acceptCookiesLocator = By.id("sp-cc-accept");
    By loginButtonLocator = By.id("nav-link-accountList");
    By myListButtonLocator = new By.ByXPath("//*[@id=\"nav-flyout-wl-items\"]/div/a");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchNox(driver);
    }

    public SearchNox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0;
    }

    public void goToCart() {
        // wait(cartContainerLocator);
        click(cartContainerLocator);
    }

    private int getCartCount(){
        // wait(cartCountLocator);
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void acceptCookies(){
        // wait(acceptCookiesLocator);
        if(isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }

    public void goToLoginPage(){
        click(loginButtonLocator);
    }


    public void goToMyList(){
        Actions actions = new Actions(driver);
        WebElement loginButton = find(loginButtonLocator);
        actions.moveToElement(loginButton).perform();
        click(myListButtonLocator);
    }


}
