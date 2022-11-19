import io.cucumber.java.ru.Допустим;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import ru.one.crud.entity.Book;

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
public class CreateBookTest extends StarterTest {
    @Test
    public void test1() {
        ResponseEntity<Book> book = httpClient.request();
    }

    @Допустим("пользователь передает данные для создания книги")
    public void пользователь_передает_данные_для_создания_книги() {
        ResponseEntity<Book> book = httpClient.request();
    }

    //    @Если("пользователь передал корректные данные")
//    public void пользователь_передал_корректные_данные() {
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//    }
//
//    @То("программа вернула созданный объект")
//    public void программа_вернула_созданный_объект() {
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//    }
}
