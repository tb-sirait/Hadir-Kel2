package com.example.stepdefs;

import com.example.hooks.Hooks;
import com.example.pages.LoginPage;
import com.example.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    private WebDriver driver;
    private ExtentTest extentTest;
    private LoginPage loginPage;

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        loginPage = new LoginPage(driver);
    }
    @Given("akses url invalid")
    public void akses_url_invalid() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "Akses Url");
    }

    @When("user input username invalid")
    public void user_input_username_invalid() {
        Hooks.delay(1);
        loginPage.setInputEmail("invalid@hadir.com");
        extentTest.log(LogStatus.PASS, "User input username invalid");
    }

    @When("user input password invalid")
    public void user_input_password_invalid() {
        Hooks.delay(1);
        loginPage.setInputPassword("wrongpassword");
        extentTest.log(LogStatus.PASS, "User input password invalid");
    }

    @When("click login button invalid")
    public void click_login_button_invalid() {
        Hooks.delay(1);
        loginPage.setBtnMasuk();
        extentTest.log(LogStatus.PASS, "Click login button");
    }

    @Then("validate result failed login page")
    public void validate_result_failed_login_page() {
        Hooks.delay(2);
        // Assert untuk memastikan error message muncul
        Assert.assertEquals(loginPage.getInvalidTxtDashboard(), "");
        extentTest.log(LogStatus.FAIL, "invalid login dan tidak menampilkan halaman dashboard");
    }



    @Given("akses url")
    public void akses_url() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "Akses Url");
    }

    @When("user input username")
    public void user_input_username() {
        Hooks.delay(1);
        loginPage.setInputEmail("admin@hadir.com");
        extentTest.log(LogStatus.PASS, "invalid login dan tidak menampilkan halaman dashboard");
    }

    @When("user input password")
    public void user_input_password() {
        Hooks.delay(1);
        loginPage.setInputPassword("admin@hadir");
        extentTest.log(LogStatus.PASS, "User input password");
    }

    @When("click login button")
    public void click() {
        Hooks.delay(1);
        loginPage.setBtnMasuk();
        extentTest.log(LogStatus.PASS, "Click login button");
    }

    @Then("validate result login page")
    public void validate_result_login_page() {
        Hooks.delay(2);
        Assert.assertEquals(loginPage.getResultTxtDashboard(), "Admin Hadir");
        extentTest.log(LogStatus.PASS, "berhasil login dan menampilkan halaman dashboard");

    }

}
