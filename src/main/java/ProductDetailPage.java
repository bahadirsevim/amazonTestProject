import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("add-to-cart-button");
    By productTitleLocator = new By.ByXPath("//*[@id=\'productTitle\']");
    By htmlTag = By.tagName("html");
    By addToFavoritesButtonLocator = By.id("add-to-wishlist-button-submit");
    By viewYourFavoritesListButtonLocator = By.id("huc-view-your-list-button");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        // wait(addToCartButtonLocator);
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        // wait(addToCartButtonLocator);
        click(addToCartButtonLocator);
    }

    public String getProductTitle(){
        // wait(productTitleLocator);
        return find(productTitleLocator).getText();
    }

    public void  addToFavoritesList(){
        sendKeyboard(htmlTag, Keys.SPACE);
        click(addToFavoritesButtonLocator);
    }
    public void goToFavoritesList(){
        click(viewYourFavoritesListButtonLocator);
    }
}
