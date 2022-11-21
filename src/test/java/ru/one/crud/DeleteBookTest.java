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

import java.util.NoSuchElementException;

public class DeleteBookTest {
    @Autowired
    HTTPClient httpClient;

    @Autowired
    private BookRepository bookRepository;

    @Допустим("пользователь передает данные для удаления книги")
    public void пользователь_обновляет_данные_книги() {

    }

    @Если("Книга имеется в базе данных")
    public void книга_имеется_в_базе_данных() {

    }

    @То("Книга удалена")
    public void программа_обновляет_данные_книги_с_id() {
        Book book = TestUtilityClass.createTestBook();
        book = bookRepository.saveAndFlush(book);
        long createdBookId = book.getId();
        httpClient.requestDelete(book).getBody();
        NoSuchElementException thrown =
                Assertions.assertThrows(NoSuchElementException.class,
                        () -> bookRepository.findById(createdBookId).get());
    }

    @Если("книги нет в базе данных")
    public void пользователь_передал_не_существующий_id() {

    }

    @То("программа выдает ошибку")
    public void программа_не_находит_книгу() {
        Book book = TestUtilityClass.createTestBook();
        HttpServerErrorException.InternalServerError thrown =
                Assertions.assertThrows(HttpServerErrorException.InternalServerError.class,
                        () -> httpClient.requestDelete(book).getBody());
    }
}