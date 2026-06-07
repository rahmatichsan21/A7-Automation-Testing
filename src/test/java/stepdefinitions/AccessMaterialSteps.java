package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import java.time.Duration;
import static org.junit.Assert.*;

public class AccessMaterialSteps {

    private WebDriver driver;
    private static final String BASE_URL = "https://polban-space.cloudias79.com/jtk-learn/";

    @Given("Pelajar telah login dan membuka materi pertama CyberSecurity")
    public void pelajar_login_dan_buka_materi() throws InterruptedException {
        driver = Hooks.driver;
        driver.get(BASE_URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputCredentials("nessierdays@gmail.com", "12345678");
        loginPage.clickLoginButton();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement card = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//h6[@class='custom-card-title' and text()='CyberSecurity']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
        Thread.sleep(500);
        card.click();
        Thread.sleep(2000);

        WebElement lanjutkanBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector("button.button-overview")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lanjutkanBtn);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lanjutkanBtn);
        Thread.sleep(3000);

        driver.get("https://polban-space.cloudias79.com/jtk-learn/learn-course/36");
        Thread.sleep(2000);
    }

    @When("Pelajar mengklik tombol Selanjutnya")
    public void pelajar_klik_selanjutnya() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("span.next-button"))).click();
        Thread.sleep(2000);
    }

    @Then("Sistem menampilkan materi selanjutnya")
    public void sistem_menampilkan_materi_selanjutnya() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("h3.material-title")));
        assertEquals("Pengantar", title.getText());
    }
}