package ru.one.crud;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpServerErrorException;
import ru.one.crud.entity.Book;
import ru.one.crud.repository.BookRepository;
import ru.one.crud.utils.HTTPClient;
import ru.one.crud.utils.TestUtilityClass;

public class UpdateBookTest {
    @Autowired
    HTTPClient httpClient;

    @Autowired
    private BookRepository bookRepository;

    @Допустим("Пользователь обновляет данные книги")
    public void пользователь_обновляет_данные_книги() {

    }

    @Если("книга имеется в базе данных")
    public void книга_имеется_в_базе_данных() {

    }

    @То("программа обновляет данные книги")
    public void программа_обновляет_данные_книги_с_id() {
        Book book = TestUtilityClass.createTestBook();
        book = bookRepository.saveAndFlush(book);
        book.setName("Обновленная тест-книга");
        book.setAuthor("Обновленный тест-автор");
        book.setRelease("2000");
        book.setPrivateCatalog(false);
        Book bookFromHttpClient = httpClient.requestUpdate(book).getBody();
        Assertions.assertEquals(book.getName(), bookFromHttpClient.getName());
        Assertions.assertEquals(book.getAuthor(), bookFromHttpClient.getAuthor());
        Assertions.assertEquals(book.getRelease(), bookFromHttpClient.getRelease());
        Assertions.assertEquals(book.isPrivateCatalog(), bookFromHttpClient.isPrivateCatalog());
        bookRepository.delete(bookFromHttpClient);
    }

    @Если("пользователь передал не существующий id")
    public void пользователь_передал_не_существующий_id() {

    }

    @То("программа не находит книгу базе данных и выдает ошибку")
    public void программа_не_находит_книгу() {
        Book book = TestUtilityClass.createTestBook();
        HttpServerErrorException.InternalServerError thrown =
                Assertions.assertThrows(HttpServerErrorException.InternalServerError.class,
                        () -> httpClient.requestUpdate(book).getBody());
    }
}