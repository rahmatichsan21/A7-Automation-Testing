package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Perbaikan Web Locator menggunakan XPath berdasarkan atribut tipe input
    @FindBy(xpath = "//input[@type='email']") 
    private WebElement fieldUsername;

    @FindBy(xpath = "//input[@type='password']") 
    private WebElement fieldPassword;

    // Tombol login menggunakan XPath berdasarkan atribut tipe submit
    @FindBy(xpath = "//button[@type='submit']") 
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputCredentials(String username, String password) {
        fieldUsername.sendKeys(username);
        fieldPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public boolean isLoginPageDisplayed() {
        return btnLogin.isDisplayed();
    }
}