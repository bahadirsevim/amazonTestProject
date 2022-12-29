import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritesListPage extends BasePage{
    By titleOfAddedProducts = new By.ByXPath("//h2[@class=\"a-size-base\"]/a");
    By deleteButtonLocator = new By.ByName("submit.deleteItem");
    By htmlTag = By.tagName("html");
    By randomAProductLocator = new By.ByXPath("//*[@id='anonCarousel1']/ol/li[2]/div/a[2]/span/div");
    WebElement deleteButtonElement;
    ProductDetailPage productDetailPage;

    public FavoritesListPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getProductNames(){
        return findAll(titleOfAddedProducts);
    }

    private List<WebElement> getDeleteProductButtons(){
        return findAll(deleteButtonLocator);
    }

    public String getLastProductName(){
        return getProductNames().get(0).getText();
    }

    public void deleteLastProduct(){
        if (getProductNames().isEmpty()){
            addARandomProduct();
        }
        deleteButtonElement = getDeleteProductButtons().get(0);
        deleteButtonElement.click();
    }

    public void deleteAllProducts(){
        List<WebElement> deleteButtonList = getDeleteProductButtons();
        for (WebElement deleteButton: deleteButtonList) {
            deleteButton.click();
        }
    }

    public void addARandomProduct(){
        sendKeyboard(htmlTag, Keys.SPACE);
        productDetailPage = new ProductDetailPage(driver);
        click(randomAProductLocator);
        productDetailPage.addToFavoritesList();
        productDetailPage.goToFavoritesList();
    }

}
