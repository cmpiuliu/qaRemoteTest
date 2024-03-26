package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/features"
        ,glue={"stepsDefinition", "hooks"},
        plugin = { "pretty", "html:target/cucumber.html" },
        monochrome = true

)

public class TestRunner {
}
