package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import pages.DashboardPage;
import pages.LoginPage;

public class CommonSteps {

    @Given("Pelajar telah berhasil login ke dalam aplikasi JTKLearn")
    public void pelajar_telah_berhasil_login() {
        // Memanggil driver statis dari kelas Hooks
        Hooks.driver.get("https://polban-space.cloudias79.com/jtk-learn");

        // Inisialisasi Page Object Model
        LoginPage loginPage = new LoginPage(Hooks.driver);
        DashboardPage dashboardPage = new DashboardPage(Hooks.driver);

        // Eksekusi Login menggunakan kredensial baru
        loginPage.inputCredentials("Ichsan@example.com", "Ichsan21");
        loginPage.clickLoginButton();

        // Validasi
        Assert.assertTrue("Gagal masuk ke halaman Dashboard", dashboardPage.isDashboardDisplayed());
    }
}