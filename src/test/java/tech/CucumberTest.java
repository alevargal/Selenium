package tech;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //monochrome = true,
        glue = {"tech/stepdefs"},
        features = {"src/test/resources/features/"},
        tags = "@test"
        //snippets = SnippetType.CAMELCASE
)

public class CucumberTest {
}