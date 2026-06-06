package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    // 1. Locator baru untuk verifikasi halaman utama (Beranda)
    @FindBy(xpath = "//a[contains(text(), 'Beranda')]")
    private WebElement navBeranda;

    // 2. Locator untuk navigasi Profil (untuk membuka dropdown)
    @FindBy(xpath = "//li[contains(@class, 'dropdown')]/a")
    private WebElement dropdownProfile;

    // 3. Locator untuk tombol Keluar
    @FindBy(xpath = "//button[contains(., 'Keluar')]")
    private WebElement btnLogout;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        try {
            // Tunggu hingga elemen "Beranda" benar-benar muncul di layar
            wait.until(ExpectedConditions.visibilityOf(navBeranda));
            return navBeranda.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void clickLogoutButton() {
        // Langkah 1: Klik profil untuk menjatuhkan menu dropdown
        wait.until(ExpectedConditions.elementToBeClickable(dropdownProfile));
        dropdownProfile.click();

        // Langkah 2: Tunggu hingga tombol Keluar muncul, lalu klik
        wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        btnLogout.click();
    }
}