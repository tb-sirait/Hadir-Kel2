package Runner.UserTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/User/UserReset.feature"}, glue = {"User.Reset"})

public class UserResetTest extends AbstractTestNGCucumberTests {

}
