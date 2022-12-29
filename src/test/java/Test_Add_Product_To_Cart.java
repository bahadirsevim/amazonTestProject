import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest{

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
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
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Product count didn't increase");
    }

    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkProductAdded(), "Product is not added");
    }

    @Test
    @Order(6)
    public void is_current_product(){
        String lastProductNameInCart = cartPage.getLastProductName();
        Assertions.assertTrue(productTitle.equals(lastProductNameInCart), "The product added to cart isn't the same");
    }

}
