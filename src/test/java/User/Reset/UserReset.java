package User.Reset;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserReset {
    WebDriver driver;
    ChromeOptions options;

    @Before
    public void setUp(){
        options = new ChromeOptions();
        options.setBinary("C:\\MyTools\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        int TIMEOUT = 5;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        driver.get("https://magang.dikahadir.com/authentication/login");
    }

    @Given("User wants to log in as Admin")
    public void logIn(){
        try{
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Masuk')]"));

            emailField.sendKeys("admin@hadir.com");
            Thread.sleep(1000);
            passwordField.sendKeys("admin@hadir");
            Thread.sleep(1000);
            loginButton.click();
            Thread.sleep(6000);
        }
        catch (Exception e){
            Assert.fail(String.valueOf(e));
        }
    }

    @When("User logged in")
    public void userLoggedIn() {
        String expectedUrl = "https://magang.dikahadir.com/dashboards/pending";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login berhasil");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Assertion passed: Current URL match the expected URL.");
    }

    @Then("User direct to page Management->User")
    public void goToManagementUser(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // klo di minimize, harus buka opsi ini
//            wait.until(ExpectedConditions.elementToBeClickable(menuButton));
//            menuButton.click();
//            Thread.sleep(1000);

            // Click Management menu
            WebElement managementElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'sidebar__item') and .//p[text()='Management']]")
            ));
            managementElement.click();
            Thread.sleep(1000);

            // Click User submenu
            WebElement userElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='User']")
            ));
            userElement.click();
            Thread.sleep(1000);
        } catch (Exception e){
            Assert.fail(String.valueOf(e));
        }
    }

    @Given("User find user by Nik")
    public void userFindUserByNik(){
        try {
            // Find the select element using its class or other suitable locator
            WebElement selectElement = driver.findElement(By.className("MuiSelect-select"));
            selectElement.click();
            Thread.sleep(1000);

            WebElement nik = driver.findElement(
                    By.xpath("//li[@role='option'][@data-value='nik']")
            );
            nik.click();
            Thread.sleep(1000);

            WebElement searchInput = driver.findElement(By.id("search"));
            searchInput.sendKeys("D220728");
            Thread.sleep(1000);
            searchInput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

    }

    //search by Nik: D220728 and tag Class MuiOutlinedInput-input
    @When("User want to reset data as before")
    public void userWantToResetDataAsBefore() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            // reset kembali untuk filter selanjutnya
            WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Reset']")
            ));
            reset.click();
            Thread.sleep(4000);
        } catch (Exception e){
            Assert.fail("Tidak bisa di reset datanya");
        }
    }


    @Then("System will restore the data as before")
    public void systemWillRestoreTheDataAsBefore() {
        String expectedUrl = "https://magang.dikahadir.com/management/user";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Assertion passed: Current URL match the expected URL.");
    }


}
