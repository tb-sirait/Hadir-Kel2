package Runner.UserTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/User/UserExport.feature"}, glue = {"User.Export"})

public class UserExportTest extends AbstractTestNGCucumberTests {

}
