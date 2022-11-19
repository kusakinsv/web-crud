//import io.cucumber.java.ru.Допустим;
//import io.cucumber.spring.CucumberContextConfiguration;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import ru.one.crud.entity.Book;
//
////@Cucumber
////@CucumberOptions(
////        features = "src/test/resources/features",
////        glue = "ru.one.crud",
////        tags = "@create",
////        dryRun = false,
//////        strict = false,
////        snippets = CucumberOptions.SnippetType.UNDERSCORE
//////        name = "^Успешное|Успешная.*"
////)
////@ContextConfiguration(classes = TestConfig.class)
//@CucumberContextConfiguration
//@SpringBootTest(
//        classes = TestConfig.class,
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
//)
//public class TestRunner {
//
//    @LocalServerPort
//    private int port;
//
//    HTTPClient httpClient = new HTTPClient();
//
//    @Autowired
//    protected TestRestTemplate testRestTemplate;
//
//    @Test
//    public void test1(){
//
//    }
//
//}
