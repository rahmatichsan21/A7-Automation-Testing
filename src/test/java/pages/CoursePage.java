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

    // 1. Locator Tab Menu
    @FindBy(xpath = "//a[contains(text(), 'Kursus Saya')]")
    private WebElement tabKursusSaya;

    // 2. Locator Card Kursus
    @FindBy(xpath = "//h6[contains(text(), 'Contoh Kursus')]")
    private WebElement cardContohKursus;

    // 3. Locator Tombol Lanjutkan
    @FindBy(xpath = "//button[contains(text(), 'Lanjutkan Kursus')]")
    private WebElement btnLanjutkanKursus;

    // 4. Locator Item Materi Video
    @FindBy(xpath = "//li[contains(@class, 'learn-list-item') and contains(., 'Test Video')]")
    private WebElement listTestVideo;

    // 5. Locator Iframe YouTube
    @FindBy(xpath = "//iframe[contains(@src, 'youtube.com')]")
    private WebElement iframeYouTube;

    // 6. Locator Ikon Play YouTube
    @FindBy(xpath = "//button[contains(@class, 'ytmCuedOverlayPlayButton')]")
    private WebElement iconPlayYouTube;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Inisialisasi JavaScript Executor
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // --- HELPER METHOD UNTUK KLIK ANTI-GAGAL ---
    private void clickWithJS(WebElement element) {
        // Tunggu elemen muncul dulu di DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(
            org.openqa.selenium.By.xpath(element.toString().split("-> xpath: ")[1].replaceFirst("]$", ""))
        ));
        // Eksekusi klik langsung ke jantung HTML-nya
        js.executeScript("arguments[0].click();", element);
    }

    public void clickTabKursusSaya() {
        // Mengganti klik standar dengan JS Click
        clickWithJS(tabKursusSaya);
    }

    public void clickCardContohKursus() {
        clickWithJS(cardContohKursus);
    }

    public void clickBtnLanjutkanKursus() {
        clickWithJS(btnLanjutkanKursus);
    }

    public void clickMateriTestVideo() {
        clickWithJS(listTestVideo);
    }

    public void interactWithYouTubePlayer() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeYouTube));
        
        // Klik YouTube menggunakan JS Click untuk menembus proteksi invisible element
        js.executeScript("arguments[0].click();", iconPlayYouTube);
        
        driver.switchTo().defaultContent();
    }
}