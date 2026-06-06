package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutSteps {
    
    DashboardPage dashboardPage;
    LoginPage loginPage;

    // Metode helper untuk Lazy Initialization Page Object
    private void initPages() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(Hooks.driver);
        }
        if (loginPage == null) {
            loginPage = new LoginPage(Hooks.driver);
        }
    }

    @When("Pelajar mengklik menu Keluar pada bagian header navigasi")
    public void pelajar_mengklik_menu_keluar_pada_bagian_header_navigasi() {
        initPages();
        dashboardPage.clickLogoutButton();
    }

    @Then("Sistem menghapus sesi login dan mengarahkan Pelajar kembali ke halaman Login")
    public void sistem_menghapus_sesi_login_dan_mengarahkan_pelajar_kembali_ke_halaman_login() {
        initPages();
        Assert.assertTrue("Pengguna tidak diarahkan kembali ke halaman Login", loginPage.isLoginPageDisplayed());
    }
}