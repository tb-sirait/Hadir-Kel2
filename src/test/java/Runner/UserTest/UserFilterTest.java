package Runner.UserTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/User/UserFilter.feature"}, glue = {"User.Filter"})

public class UserFilterTest extends AbstractTestNGCucumberTests {

}
