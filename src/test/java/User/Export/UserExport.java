package User.Export;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UserExport {
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

    @Given("User logged in as Admin")
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


    @When("User in Dashboard page")
    public void userInDashboardPage() {
        String expectedUrl = "https://magang.dikahadir.com/dashboards/pending";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Assertion passed: Current URL match the expected URL.");
    }

    @Then("direct to Management->User")
    public void directToManagementUser() {
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

    @Given("User want to export")
    public void userWantToExport(){
        String expectedPage = "https://magang.dikahadir.com/management/user";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedPage);
    }

    @When("User click Export button")
    public void userClickExportButton() throws InterruptedException {
        // Temukan tombol Export berdasarkan kelasnya
        WebElement exportButton = driver.findElement(By.cssSelector(".button-add"));
        exportButton.click();
        Thread.sleep(10000); // menunggu semua data kepanggil
    }

    @Then("System exporting {string} to local directory")
    public void systemExportingToLocalDirectory(String dataDownload) {
        String downloadDirectory = "C:\\Users\\tbsin\\Downloads";
        File[] files = new File(downloadDirectory).listFiles();

        boolean fileFound = false;
        assert files != null;
        for (File file : files) {
            if (file.getName().equals("export-users.xlsx")) {
                fileFound = true;
                break;
            }
        }

        if (fileFound) {
            System.out.println("File export-users.xlsx berhasil diunduh!");
        } else {
            System.out.println("File export-users.xlsx tidak ditemukan.");
        }
    }

    @After
    public void endClass(){
        driver.quit();
    }
}
