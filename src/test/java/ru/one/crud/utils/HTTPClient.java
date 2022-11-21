package ru.one.crud.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.one.crud.entity.Book;


public class HTTPClient {
    @Value("${server.api.url}")
    private String URL;

    public ResponseEntity<Book> requestRead(long id){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Book> responseOutput = restTemplate.exchange(URL + "/read/" + id, HttpMethod.GET, requestEntity, Book.class);
        return responseOutput;

    }

    public ResponseEntity requestCreate(Book book){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> requestEntity = new HttpEntity<>(book, httpHeaders);
        ResponseEntity<Book> responseOutput = restTemplate.exchange(URL + "/create", HttpMethod.POST, requestEntity, Book.class);
        System.out.println(responseOutput.getBody());
        return responseOutput;
    }

    public ResponseEntity<Book> requestUpdate(Book book){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> requestEntity = new HttpEntity<>(book, httpHeaders);
        ResponseEntity<Book> responseOutput = restTemplate.exchange(URL + "/update/" + book.getId(), HttpMethod.POST, requestEntity, Book.class);
        System.out.println(responseOutput.getBody());
        return responseOutput;
    }

    public ResponseEntity<Book> requestDelete(Book book){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> requestEntity = new HttpEntity<>(book, httpHeaders);
        ResponseEntity<Book> responseOutput = restTemplate.exchange(URL + "/delete/" + book.getId(), HttpMethod.POST, requestEntity, Book.class);
        System.out.println(responseOutput.getBody());
        return responseOutput;
    }
}
