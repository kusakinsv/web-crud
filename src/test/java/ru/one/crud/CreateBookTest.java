package ru.one.crud;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import ru.one.crud.entity.Book;
import ru.one.crud.repository.BookRepository;
import ru.one.crud.utils.HTTPClient;
import ru.one.crud.utils.TestUtilityClass;

public class CreateBookTest {
    @Autowired
    HTTPClient httpClient;

    @Autowired
    private BookRepository bookRepository;

    @Допустим("пользователь передает данные для создания книги")
    public void пользователь_передает_данные_для_создания_книги() {
    }

    @Если("пользователь передал корректные данные")
    public void пользователь_передал_корректные_данные() {
    }

    @То("программа вернула созданный объект")
    public void программа_вернула_созданный_объект() {
        ResponseEntity<Book> bookResponseEntity = httpClient.requestCreate(TestUtilityClass.createTestBook());
        Book book = bookResponseEntity.getBody();
        assert book != null;
        TestUtilityClass.setTestId(book.getId());
        Assertions.assertEquals("Тестовая книга", book.getName());
        Assertions.assertEquals("Тестовый автор", book.getAuthor());
        Assertions.assertEquals("2022", book.getRelease());
        Assertions.assertTrue(book.isPrivateCatalog());
        bookRepository.delete(book);
    }

    @Если("пользователь передал некорректные данные")
    public void пользователь_передал_не_корректные_данные() {
    }

    @То("программа выдает ошибку Bad Request")
    public void программа_выдает_ошибку() {
        HttpClientErrorException.BadRequest thrown =
                Assertions.assertThrows(HttpClientErrorException.BadRequest.class,
                        () -> httpClient.requestCreate(null));
    }

    private void deleteTestBook(Book book){
        bookRepository.delete(book);
    }
}