package ru.one.crud;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.one.crud.entity.Book;


public class HTTPClient {

    private final String URL = "http://localhost:8282/api/books";

    public ResponseEntity requestRead(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseOutput = restTemplate.exchange(URL + "/read", HttpMethod.GET, requestEntity, String.class);
        System.out.println(responseOutput.getBody());
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




}
