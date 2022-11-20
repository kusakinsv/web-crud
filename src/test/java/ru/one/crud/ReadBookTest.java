package ru.one.crud;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import ru.one.crud.entity.Book;
import ru.one.crud.repository.BookRepository;

import java.util.NoSuchElementException;

public class ReadBookTest {
    @Autowired
    private HTTPClient httpClient;

    @Autowired
    private BookRepository bookRepository;

    @Допустим("Пользователь запрашивает данные книги")
    public void пользователь_запрашивает_данные_книги() {

    }

    @Если("^книга c id (\\d+) имеется в базе данных$")
    public void такая_книга_есть(long id) {
         Book book = httpClient.requestRead(id).getBody();
    }

    @То("^программа возвращает данные книги c id (\\d+)$")
    public void программа_возвращает_данные_книги(long id) {
        ResponseEntity<Book> bookResponseEntity = httpClient.requestRead(id);
        Book book = bookResponseEntity.getBody();
        assert book != null;
        Book bookFromRepo = bookRepository.findById(id).get();
        TestUtilityClass.setTestId(book.getId());
        Assertions.assertEquals(bookFromRepo.getName(), book.getName());
        Assertions.assertEquals(bookFromRepo.getAuthor(), book.getAuthor());
        Assertions.assertEquals(bookFromRepo.getRelease(), book.getRelease());
        Assertions.assertEquals(bookFromRepo.isPrivateCatalog(), book.isPrivateCatalog());
    }


    @Если("^пользователь передал не существующий id (\\d+)$")
    public void пользователь_передал_не_существующий_id(long id) {

    }

    @То("^программа не находит книгу с id (\\d+) в базе данных$")
    public void программа_не_находит_книгу_с_id_в_базе_данных(long id) {
        HttpServerErrorException.InternalServerError thrown =
                Assertions.assertThrows(HttpServerErrorException.InternalServerError.class,
                        () -> httpClient.requestRead(id));
    }

}
