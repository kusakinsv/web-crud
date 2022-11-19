import io.cucumber.java.ru.Допустим;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import ru.one.crud.MainApplication;
import ru.one.crud.entity.Book;

@SpringBootTest(
        classes = MainApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@CucumberContextConfiguration
//@ContextConfiguration(classes = TestConfig.class)
public class StarterTest {
    public HTTPClient httpClient = new HTTPClient();

    @Autowired
    protected TestRestTemplate testRestTemplate;



}
