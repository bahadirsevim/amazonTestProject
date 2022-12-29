import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private String email = "bahadirsevim@outlook.com";
    private String password = "@@@Bahadir565757";

    By emailTextBoxLocator = By.id("ap_email");
    By continueButtonLocator = By.id("continue");
    By passwordTextBoxLocator = By.id("ap_password");
    By loginButtonLocator = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailAndContinue(){
        type(emailTextBoxLocator, email);
        click(continueButtonLocator);
    }

    public void setPasswordAndLogin(){
        type(passwordTextBoxLocator, password);
        click(loginButtonLocator);
    }


}
