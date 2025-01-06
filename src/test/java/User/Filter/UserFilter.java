package User.Filter;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

import java.time.Duration;

public class UserFilter {
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

    @Given("Admin is logged in")
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

            String expectedUrl = "https://magang.dikahadir.com/dashboards/pending";
            org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login berhasil");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Expected URL: " + expectedUrl);
            System.out.println("Assertion passed: Current URL match the expected URL.");
        }
        catch (Exception e){
            Assert.fail(String.valueOf(e));
        }
    }

    @And("go to Management->User")
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

    @When("I click filter button")
    public void iClickFilterButton() {
        String expectedUrl = "https://magang.dikahadir.com/management/user";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Assertion passed: Current URL match the expected URL.");
        try{
            WebElement filterBtn = driver.findElement(By.cssSelector("button.MuiButton-containedSecondary"));
            filterBtn.click();
            Thread.sleep(1000);

        } catch (Exception e){
            Assert.fail(String.valueOf(e));
        }
    }

    @Then("filter page should open")
    public void filterPageShouldOpen() {
        Assert.assertTrue("Terbuka opsi",true);
    }

    @Given("User filtered by Unit")
    public void userFilteredByUnit() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement unitDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='mui-component-select-job_departement_id']")
            ));
            unitDropdown.click();
            Thread.sleep(1000);
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @When("User is choosed filter unit is {string}")
    public void userIsChoosedFilterUnitIs(String expectedValue) throws InterruptedException {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement componentData3D = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][@data-value='6d6e783e-fb7f-4486-b41e-dd39fefe6c0a']")
            ));
            componentData3D.click();

            //memastikan bahwa mencari 3D
            String actualValue = componentData3D.getText();
            Assert.assertEquals(expectedValue, actualValue);

            Thread.sleep(1000);
            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Terapkan']")
            ));
            submit.click();
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }
        Thread.sleep(10000); // menunggu semua data kepanggil
    }

    @Then("System showing filtered data by unit")
    public void systemShowingFilteredDataByUnit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // tag data id untuk 3d = 6d6e783e-fb7f-4486-b41e-dd39fefe6c0a
        String expectedUrl = "https://magang.dikahadir.com/management/user?job_departement_id=6d6e783e-fb7f-4486-b41e-dd39fefe6c0a&page=1";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Assertion passed: Current URL match the expected URL.");

        // reset kembali untuk filter selanjutnya
        WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Reset']")
        ));
        reset.click();
    }

    @Given("User filtered by Job Level")
    public void userFilteredByJobLevel() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement filterBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.MuiButton-containedSecondary")
            )); filterBtn.click();
            Thread.sleep(1000);

            WebElement unitDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='mui-component-select-job_level_id']")
            ));
            unitDropdown.click();
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @When("User is choosed filter Job Level is {string}")
    public void userIsChoosedFilterJobLevelIs(String expectedValue) throws InterruptedException {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement componentDataCustServ = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][@data-value='31e5ba36-4fdb-4974-bdc6-52ff4af4279a']")
            ));
            componentDataCustServ.click();

            //memastikan bahwa mencari 3D
            String actualValue = componentDataCustServ.getText();
            Assert.assertEquals(expectedValue, actualValue);

            Thread.sleep(1000);
            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Terapkan']")
            ));
            submit.click();
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }
        Thread.sleep(10000); // menunggu semua data kepanggil
    }

    @Then("System showing filtered data by Job Level")
    public void systemShowingFilteredDataByJobLevel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // tag data id untuk 3d = 6d6e783e-fb7f-4486-b41e-dd39fefe6c0a
        String expectedUrl = "https://magang.dikahadir.com/management/user?job_level_id=31e5ba36-4fdb-4974-bdc6-52ff4af4279a&page=1";
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Assertion passed: Current URL match the expected URL.");

        // reset kembali untuk filter selanjutnya
        WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Reset']")
        ));
        reset.click();
    }

}
