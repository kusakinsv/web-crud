package ru.one.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.one.crud.entity.Book;
import ru.one.crud.repository.BookRepository;

import java.util.HashMap;

@RestController
@RequestMapping("/api/books")
public class BookJSONController {
    BookRepository bookRepository;

    @PostMapping(value ={"create"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book newBook = new Book();
        newBook.setName(book.getName());
        newBook.setAuthor(book.getAuthor());
        newBook.setRelease(book.getRelease());
        newBook.setPrivateCatalog(book.isPrivateCatalog());
        bookRepository.save(newBook);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping(value ={"read","read/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity read(@PathVariable(name = "id", required = false) Long id) {
        if (id != null){
            return ResponseEntity.ok(bookRepository.findById(id).get());
        } else {
            return ResponseEntity.ok(bookRepository.findAll());
        }
    }

    @PostMapping(value ={"update","update/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        Book findedBook = bookRepository.findById(id).get();
        findedBook.setName(book.getName());
        findedBook.setAuthor(book.getAuthor());
        findedBook.setRelease(book.getRelease());
        findedBook.setPrivateCatalog(book.isPrivateCatalog());
        bookRepository.save(findedBook);
        return ResponseEntity.ok(findedBook);
    }

    @PostMapping(value ={"delete", "delete/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteBook(@RequestBody Book book, @PathVariable(name = "id", required = false) Long id) throws Exception {
        if (id == null) throw new Exception("Error: empty id");
        Book findedBook = bookRepository.findById(id).get();
        bookRepository.delete(findedBook);
        return ResponseEntity.ok((new HashMap<String, String>() {{
            put("system", "Book with id " + id + " DELETED");
        }}));
    }

    @GetMapping(value ={"readAllPrivate"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity readAllPrivate() {
        return ResponseEntity.ok(bookRepository.findByPrivateCatalogIsTrue().get());
    }

    @GetMapping(value ={"readAllPublic"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity readAllNotPrivate() {
        return ResponseEntity.ok(bookRepository.findByPrivateCatalogIsFalse().get());
    }
    
    @GetMapping(value ={"readAll"})
    public ResponseEntity readAll() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
    @GetMapping("echo")
    public ResponseEntity echo() {
        return ResponseEntity.ok("Hello");
    }

    @Autowired
    public BookJSONController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
