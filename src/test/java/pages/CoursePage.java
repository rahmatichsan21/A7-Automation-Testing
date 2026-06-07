package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(), 'Kursus Saya')]")
    private WebElement tabKursusSaya;

    @FindBy(xpath = "//h6[contains(text(), 'Contoh Kursus')]")
    private WebElement cardContohKursus;

    @FindBy(xpath = "//h6[contains(text(), 'CyberSecurity')]")
    private WebElement cardCyberSecurity;

    @FindBy(xpath = "//button[contains(text(), 'Lanjutkan Kursus')]")
    private WebElement btnLanjutkanKursus;

    @FindBy(xpath = "//li[contains(@class, 'learn-list-item') and contains(., 'Test Video')]")
    private WebElement listTestVideo;

    @FindBy(xpath = "//li[contains(@class, 'learn-list-item') and contains(., 'PDF')]")
    private WebElement listTestPDF;

    @FindBy(xpath = "//iframe[contains(@src, 'youtube.com')]")
    private WebElement iframeYouTube;

    @FindBy(xpath = "//iframe[contains(@src, '.pdf') or @type='application/pdf']")
    private WebElement iframePDF;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickTabKursusSaya() {
        wait.until(ExpectedConditions.elementToBeClickable(tabKursusSaya)).click();
    }

    public void clickCardContohKursus() {
        wait.until(ExpectedConditions.elementToBeClickable(cardContohKursus)).click();
    }

    public void clickCardCyberSecurity() {
        wait.until(ExpectedConditions.elementToBeClickable(cardCyberSecurity)).click();
    }

    public void clickBtnLanjutkanKursus() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLanjutkanKursus));
        try {
            btnLanjutkanKursus.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Jika terhalang elemen lain (misal footer/overlay), gunakan JavaScript untuk scroll dan klik
            org.openqa.selenium.JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", btnLanjutkanKursus);
            executor.executeScript("arguments[0].click();", btnLanjutkanKursus);
        }
    }

    public void clickMateriTestVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(listTestVideo)).click();
    }

    public void clickMateriTestPDF() {
        wait.until(ExpectedConditions.elementToBeClickable(listTestPDF)).click();
    }

    // Metode asersi: Hanya memastikan iframe dirender dengan benar oleh JTKLearn
    public boolean isYouTubeVideoDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(iframeYouTube));
            return iframeYouTube.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isPDFDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(iframePDF));
            return iframePDF.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}