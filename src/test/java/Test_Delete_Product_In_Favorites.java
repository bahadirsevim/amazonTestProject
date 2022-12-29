import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class Test_Delete_Product_In_Favorites extends BaseTest{
    HomePage homePage;
    FavoritesListPage favoritesListPage;

    @Test
    @Order(1)
    public void login(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        LoginPage loginPage = new LoginPage(driver);
        homePage.goToLoginPage();
        loginPage.setEmailAndContinue();
        loginPage.setPasswordAndLogin();
    }

    @Test
    @Order(2)
    public void go_to_my_list(){
        favoritesListPage = new FavoritesListPage(driver);
        homePage.goToMyList();
    }

    @Test
    @Order(3)
    public void delete_the_product(){
        favoritesListPage.deleteLastProduct();
    }

    @Test
    @Order(4)
    @Disabled("Test 3 is running")
    public void delete_all_products(){
        favoritesListPage.deleteAllProducts();
    }

}
