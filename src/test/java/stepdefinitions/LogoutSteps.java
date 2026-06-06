package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutSteps {
    
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("Pelajar dalam status sudah login dan berada di halaman Dashboard")
    public void pelajar_dalam_status_sudah_login_dan_berada_di_halaman_dashboard() {
        // 1. Inisialisasi peramban Google Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Pengaturan waktu tunggu implisit agar elemen termuat sempurna
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // 2. Navigasi ke halaman login aplikasi
        driver.get("https://polban-space.cloudias79.com/jtk-learn");
        
        // 3. Inisialisasi objek halaman
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        
        // 4. Melakukan input kredensial secara manual untuk memenuhi prasyarat sesi
        loginPage.inputCredentials("Ichsan@example.com", "Ichsan21"); 
        loginPage.clickLoginButton();
        
        // 5. Validasi bahwa login berhasil dan sistem menampilkan Dashboard
        Assert.assertTrue("Gagal masuk ke halaman Dashboard", dashboardPage.isDashboardDisplayed());
    }

    @When("Pelajar mengklik menu Keluar pada bagian header navigasi")
    public void pelajar_mengklik_menu_keluar_pada_bagian_header_navigasi() {
        // Menjalankan aksi klik pada tombol logout
        dashboardPage.clickLogoutButton();
    }

    @Then("Sistem menghapus sesi login dan mengarahkan Pelajar kembali ke halaman Login")
    public void sistem_menghapus_sesi_login_dan_mengarahkan_pelajar_kembali_ke_halaman_login() {
        // 1. Memvalidasi bahwa komponen input pada halaman login kembali muncul di layar
        Assert.assertTrue("Pengguna tidak diarahkan kembali ke halaman Login", loginPage.isLoginPageDisplayed());
        
        // 2. Mengakhiri sesi WebDriver dan menutup peramban
        if (driver != null) {
            driver.quit();
        }
    }
}