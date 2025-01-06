package PendaftaranUser .Daftar;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegUser  {
    private WebDriver driver;
    private UserRegistrationPage registrationPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\MyTools\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://magang.dikahadir.com/authentication/login");

        // Initialize the UserRegistrationPage after the driver is set up
        registrationPage = new UserRegistrationPage(driver);
    }

    @Given("I am on the user registration page")
    public void iAmOnUserRegistrationPage() {
        try {
            // Login
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Masuk')]"));

            emailField.sendKeys("admin@hadir.com");
            Thread.sleep(1000);
            passwordField.sendKeys("admin@hadir");
            Thread.sleep(1000);
            loginButton.click();
            Thread.sleep(6000);

            // Verify successful login
            String expectedUrl = "https://magang.dikahadir.com/dashboards/pending";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

            // Navigate to Management > User
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement managementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'sidebar__item')]//p[text()='Management']")
            ));
            managementMenu.click();
            Thread.sleep(1000);

            WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Pendaftaran User']")
            ));
            userMenu.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            Assert.fail("Failed to navigate to user registration page: " + e.getMessage());
        }
    }

    @When("I upload an employee photo less than {int}MB")
    public void iUploadEmployeePhoto(int size) {
        registrationPage.uploadPhoto("C:\\Users\\tbsin\\Downloads\\WhatsApp Image 2024-12-16 at 08.23.40.jpeg");
    }

    @When("I enter valid NIK {string}")
    public void iEnterNik(String nik) {
        registrationPage.enterNIK(nik);
    }

    @When("I enter employee name {string}")
    public void iEnterEmployeeName(String name) {
        registrationPage.enterEmployeeName(name);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @When("I select division {string}")
    public void iSelectDivision(String division) {
        registrationPage.selectDivision(division);
    }

    @And("I select unit {string}")
    public void iSelectUnit(String unit) {
        registrationPage.selectUnit(unit);
    }

    @And("I select position {string}")
    public void iSelectPosition(String position) {
        registrationPage.posisiKerja(position);
    }

    @And("I select job title {string}")
    public void iSelectJobTitle(String jobTitle) {
        registrationPage.selectJabatan(jobTitle);
    }

    @And("I select contract type {string}")
    public void iSelectContractType(String contractType) {
        registrationPage.selectTipeKontrak(contractType);
    }

    @And("I select work location {string}")
    public void iSelectWorkLocation(String workLocation) {
        registrationPage.selectLokasiKerja(workLocation);
    }

    @And("I select work schedule {string}")
    public void iSelectWorkSchedule(String shift) {
        registrationPage.selectJadwalKerja(shift);
    }

    @And("I enter selfie is {string}")
    public void iEnterSelfieIs(String selfie) {
        registrationPage.Selfie();
    }

    @And("I enter leave balance {string}")
    public void iEnterLeaveBalance(String leaveBalance) {
        registrationPage.enterJumlahCuti(leaveBalance);
    }

    @When("I click the submit button")
    public void iClickSubmitButton() {
        registrationPage.clickSubmit();
    }

    @Then("I should see a success message")
    public void iShouldSeeSuccessMessage() {
        Assert.assertTrue(registrationPage.isSuccessMessageDisplayed());
    }

    @Then("I should see error messages for required fields")
    public void iShouldSeeErrorMessages() {
        Assert.assertTrue(registrationPage.areRequiredFieldErrorsDisplayed());
    }


}