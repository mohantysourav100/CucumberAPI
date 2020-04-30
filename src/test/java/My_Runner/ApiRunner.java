package My_Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Sourav Mohanty\\My-workspace\\Automation\\src\\test\\java\\feature\\Api.feature",
                 glue="My_stepDefination")
public class ApiRunner {

}
