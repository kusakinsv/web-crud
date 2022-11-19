package ru.one.crud;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//package ru.one.crud;
//
//import io.cucumber.java.ru.Допустим;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//import org.springframework.http.ResponseEntity;
//import ru.one.crud.entity.Book;
//
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru.one.crud",
        tags = "@create",
        dryRun = false,
//        strict = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE
//        name = "^Успешное|Успешная.*"
)
public class CreateBookTestConfig extends StarterTest {

}
