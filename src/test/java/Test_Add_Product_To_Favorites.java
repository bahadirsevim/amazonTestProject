import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Favorites extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    FavoritesListPage favoritesListPage;
    public String productTitle;

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
    public void search_a_product(){
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("laptop");
        Assertions.assertTrue(productsPage.isOnProductsPage(), "Not on Products Page");
    }

    @Test
    @Order(3)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        productTitle = productDetailPage.getProductTitle();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page");
    }

    @Test
    @Order(4)
    public void add_to_favorites_list(){
        productDetailPage.addToFavoritesList();
        favoritesListPage = new FavoritesListPage(driver);
        productDetailPage.goToFavoritesList();
        String lastProductNameInFavoritesList = favoritesListPage.getLastProductName();
        Assertions.assertTrue(productTitle.equals(lastProductNameInFavoritesList), "The product added to favorite list isn't the same");
    }

}
