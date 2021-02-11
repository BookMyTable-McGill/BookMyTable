package bookmytable.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/test/java/bookmytable/features",
        glue = "bookmytable.stepdefinitions")
public class CucumberTestsRunner {
}
