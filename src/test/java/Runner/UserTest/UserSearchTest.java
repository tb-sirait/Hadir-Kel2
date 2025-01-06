package Runner.UserTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/User/UserSearch.feature"}, glue = {"User.Search"})

public class UserSearchTest extends AbstractTestNGCucumberTests {
}
