package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
// import pages.DashboardPage; // TODO: Rekan Anda perlu mengimpor DashboardPage nanti

public class LoginSteps {

    LoginPage loginPage;
    // DashboardPage dashboardPage; // TODO: Deklarasi variabel untuk DashboardPage

    private void initLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(Hooks.driver);
        }
    }

    // --- LANGKAH BERSAMA (Digunakan oleh skenario Negative dan Positive) ---

    @Given("Pengguna telah menavigasi ke halaman login aplikasi JTKLearn")
    public void pengguna_telah_menavigasi_ke_halaman_login_aplikasi_jtklearn() {
        Hooks.driver.get("https://polban-space.cloudias79.com/jtk-learn");
    }

    @When("Pengguna memasukkan username {string} dan password {string}")
    public void pengguna_memasukkan_username_dan_password(String username, String password) {
        initLoginPage();
        loginPage.inputCredentials(username, password);
    }

    @When("Pengguna mengklik tombol login untuk otentikasi")
    public void pengguna_mengklik_tombol_login_untuk_otentikasi() {
        initLoginPage();
        loginPage.clickLoginButton();
    }

    // --- LANGKAH SPESIFIK SKENARIO NEGATIVE ---

    @Then("Sistem menampilkan notifikasi error {string} pada antarmuka")
    public void sistem_menampilkan_notifikasi_error_pada_antarmuka(String expectedMessage) {
        initLoginPage();
        Assert.assertTrue("Pesan error otentikasi tidak dirender oleh sistem!", loginPage.isErrorMessageDisplayed());
    }

    // --- LANGKAH SPESIFIK SKENARIO POSITIVE (Untuk diimplementasikan rekan Anda) ---

    @Then("Sistem mengarahkan pengguna ke halaman dashboard aplikasi")
    public void sistem_mengarahkan_pengguna_ke_halaman_dashboard_aplikasi() {
        // TODO: Implementasi logika asersi keberhasilan login di sini
        // Contoh alur yang perlu ditulis rekan Anda:
        // 1. Inisialisasi DashboardPage
        // 2. Gunakan explicit wait untuk memastikan elemen unik di Dashboard muncul (misal: elemen profil pengguna)
        // 3. Gunakan Assert.assertTrue() untuk memvalidasi elemen tersebut
        
        throw new io.cucumber.java.PendingException("Langkah asersi login sukses belum diimplementasikan.");
    }
}