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

    // 6. Locator Ikon Play YouTube (Di dalam Iframe)
    @FindBy(xpath = "//span[contains(@class, 'yt-icon-shape')]")
    private WebElement iconPlayYouTube;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickTabKursusSaya() {
        wait.until(ExpectedConditions.elementToBeClickable(tabKursusSaya));
        tabKursusSaya.click();
    }

    public void clickCardContohKursus() {
        wait.until(ExpectedConditions.elementToBeClickable(cardContohKursus));
        cardContohKursus.click();
    }

    public void clickBtnLanjutkanKursus() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLanjutkanKursus));
        btnLanjutkanKursus.click();
    }

    public void clickMateriTestVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(listTestVideo));
        listTestVideo.click();
    }

    public boolean interactWithYouTubePlayer() {
        try {
            // Langkah 1 & 2: Gunakan fungsi khusus Selenium untuk menunggu iframe siap sekaligus masuk ke dalamnya
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeYouTube));
            
            // Langkah 3: Tunggu hingga tombol YouTube di dalam iframe selesai dirender dan bisa diklik
            wait.until(ExpectedConditions.elementToBeClickable(iconPlayYouTube));
            iconPlayYouTube.click();
            
            // Langkah 4: Kembalikan fokus Selenium ke dokumen utama JTKLearn
            driver.switchTo().defaultContent();
            
            return true;
        } catch (Exception e) {
            // Mencetak pesan error teknis ke terminal agar mudah di-debug
            System.out.println("\n======== ERROR DETAIL YOUTUBE ========");
            System.out.println(e.getMessage());
            System.out.println("======================================\n");
            
            // Pastikan konteks dikembalikan ke default jika terjadi error
            driver.switchTo().defaultContent();
            return false;
        }
    }
}