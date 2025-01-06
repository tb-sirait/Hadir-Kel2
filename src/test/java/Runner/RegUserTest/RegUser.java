package Runner.RegUserTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/PendaftaranUser/RegisterUser.feature"}, glue = {"PendaftaranUser.Daftar"})

public class RegUser extends AbstractTestNGCucumberTests {
}
