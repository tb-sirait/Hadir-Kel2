package User.Search;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserSearch {
    WebDriver driver;
    ChromeOptions options;
    WebDriverWait wait;

    @Before
    public void setUp() {
        options = new ChromeOptions();
        options.setBinary("C:\\MyTools\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://magang.dikahadir.com/authentication/login");
    }

    @Given("I navigate to the search page")
    public void navigateToSearchPage() {
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
            Assert.assertEquals("Login failed", expectedUrl, driver.getCurrentUrl());

            // Navigate to Management > User
            WebElement managementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'sidebar__item')]//p[text()='Management']")
            ));
            managementMenu.click();
            Thread.sleep(1000);

            WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='User']")
            ));
            userMenu.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            Assert.fail("Failed to navigate to search page: " + e.getMessage());
        }
    }

    @When("I select {string} from the search by dropdown")
    public void selectSearchByDropdown(String searchBy) {
        try {
            // Wait for any loading to finish
            Thread.sleep(1000);

            // Click dropdown to open options
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div[role='combobox']")
            ));
            dropdown.click();
            Thread.sleep(1000);

            // Wait for dropdown menu to be visible
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("ul[role='listbox']")
            ));

            // Debug: Print available options
            List<WebElement> options = driver.findElements(By.cssSelector("li[role='option']"));
            System.out.println("Available options:");
            for (WebElement opt : options) {
                System.out.println("Text: " + opt.getText() + " Value: " + opt.getAttribute("data-value"));
            }

            // Select option
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[contains(@class, 'MuiMenuItem-root') and text()='" + searchBy + "']")
            ));
            option.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            Assert.fail("Failed to select from dropdown: " + e.getMessage());
        }
    }

    @When("I enter {string} in the search input and press Enter")
    public void enterSearchInput(String query) {
        try {
            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("search")
            ));
            searchInput.clear();
            searchInput.sendKeys(query);
            searchInput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

        } catch (Exception e) {
            Assert.fail("Failed to enter search query: " + e.getMessage());
        }
    }

    @Then("I should see results related to {string}")
    public void verifySearchResults(String query) {
        try {
            // Wait for results to load
            Thread.sleep(2000);

            // Verify results contain the search query
            WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(),'" + query + "')]")
            ));
            Assert.assertTrue("Search results not found for: " + query, result.isDisplayed());

        } catch (Exception e) {
            Assert.fail("Failed to verify search results: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}