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

    @FindBy(xpath = "//button[contains(text(), 'Lanjutkan Kursus')]")
    private WebElement btnLanjutkanKursus;

    @FindBy(xpath = "//li[contains(@class, 'learn-list-item') and contains(., 'Test Video')]")
    private WebElement listTestVideo;

    @FindBy(xpath = "//iframe[contains(@src, 'youtube.com')]")
    private WebElement iframeYouTube;

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

    public void clickBtnLanjutkanKursus() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLanjutkanKursus)).click();
    }

    public void clickMateriTestVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(listTestVideo)).click();
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
}