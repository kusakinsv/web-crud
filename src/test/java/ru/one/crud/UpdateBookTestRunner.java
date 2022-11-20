package ru.one.crud;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru.one.crud",
        tags = "@update",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE
)
public class UpdateBookTestRunner extends StarterTest {

}
