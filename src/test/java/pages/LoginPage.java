package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Perbaikan Web Locator menggunakan XPath berdasarkan atribut tipe input
    @FindBy(xpath = "//input[@type='email' or @type='text' or @name='username']") 
    private WebElement fieldUsername;

    @FindBy(xpath = "//input[@type='password' or @name='password']") 
    private WebElement fieldPassword;

    @FindBy(xpath = "//div[contains(text(), 'Username atau password salah') or contains(text(), 'salah') or contains(@class, 'error') or contains(@class, 'alert')]")
    private WebElement errorMessage;

    // Tombol login menggunakan XPath berdasarkan atribut tipe submit
    @FindBy(xpath = "//button[@type='submit']") 
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}