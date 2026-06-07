package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

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

    @FindBy(xpath = "//li[contains(@class, 'learn-list-item') and contains(., 'Pengantar')]")
    private WebElement listTestPDF;

    @FindBy(xpath = "//iframe[contains(@src, 'youtube.com')]")
    private WebElement iframeYouTube;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // --- HELPER METHOD: Menyeragamkan logika klik di satu tempat ---
    private void safeClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            // Mencoba klik standar Selenium terlebih dahulu
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Jika terhalang (intercepted), otomatis fallback ke eksekusi JavaScript
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            js.executeScript("arguments[0].click();", element);
        }
    }

    // --- PUBLIC METHODS: Bersih, seragam, dan mudah dibaca ---
    
    public void clickTabKursusSaya() {
        safeClick(tabKursusSaya);
    }

    public void clickCardContohKursus() {
        safeClick(cardContohKursus);
    }

    public void clickCardCyberSecurity() {
        safeClick(cardCyberSecurity);
    }

    public void clickBtnLanjutkanKursus() {
        safeClick(btnLanjutkanKursus);
    }

    public void clickMateriTestVideo() {
        safeClick(listTestVideo);
    }

    public void clickMateriTestPDF() {
        safeClick(listTestPDF);
    }

    // --- ASERSI VISUAL ---

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
            delay(2000); 
            org.openqa.selenium.By pdfLocator = org.openqa.selenium.By.xpath("//iframe[contains(@src, '.pdf') or @title='PDF Viewer']");
            wait.until(ExpectedConditions.presenceOfElementLocated(pdfLocator));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}