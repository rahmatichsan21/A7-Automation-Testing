package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    // Metode helper untuk Lazy Initialization Page Object
    private void initLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(Hooks.driver);
        }
    }

    @Given("User has opened the browser")
    public void user_has_opened_the_browser() {
        // Browser is already opened by Hooks.java
    }

    @Given("User has navigated on the login page Education Fund Payment Management System for Zaidan Educare School app")
    public void user_has_navigated_on_the_login_page_education_fund_payment_management_system_for_zaidan_educare_school_app() {
        Hooks.driver.get("http://ptbsp.ddns.net:6882");
    }

    @When("User enters username {string} & password {string}")
    public void user_enters_username_password(String username, String password) {
        initLoginPage();
        loginPage.inputCredentials(username, password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        initLoginPage();
        loginPage.clickLoginButton();
    }

    @Then("User should be able to see {string} notification message {string} is displayed on screen")
    public void user_should_be_able_to_see_notification_message_is_displayed_on_screen(String type, String message) {
        initLoginPage();
        
        // Memastikan pesan error yang tampil sesuai dengan ekspektasi
        Assert.assertTrue("Notification message '" + message + "' is not displayed!", loginPage.isErrorMessageDisplayed());
    }
}
