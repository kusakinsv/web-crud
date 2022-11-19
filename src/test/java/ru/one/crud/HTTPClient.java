package ru.one.crud;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.one.crud.entity.Book;


public class HTTPClient {

    private final String URL = "http://localhost:8282/api/books";

    public ResponseEntity request(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Book book = createTestBook();
        HttpEntity<Book> requestEntity = new HttpEntity<>(book, httpHeaders);
//        ResponseEntity<Book> responseOutput = restTemplate.exchange(URL + "/read", HttpMethod.POST, requestEntity, Book.class);
        ResponseEntity<String> responseOutput = restTemplate.exchange(URL + "/read", HttpMethod.GET, requestEntity, String.class);
        System.out.println(responseOutput.getBody());
        return responseOutput;

    }

    public Book createTestBook(){
        Book book = new Book();
        book.setName("Тестовая книга");
        book.setAuthor("Тестовый автор");
        book.setRelease("2022");
        book.setPrivateCatalog(true);
        return book;
    }

}
