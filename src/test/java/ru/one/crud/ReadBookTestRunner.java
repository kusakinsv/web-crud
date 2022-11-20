package ru.one.crud;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru.one.crud",
        tags = "@read",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE
)
public class ReadBookTestRunner extends StarterTest {

}
