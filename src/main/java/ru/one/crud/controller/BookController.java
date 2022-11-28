package ru.one.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.one.crud.entity.Book;
import ru.one.crud.repository.BookRepository;

@Controller
@RequestMapping("books")
public class BookController {
    BookRepository bookRepository;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("listAll")
    public String listAll(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("listPrivate")
    public String listPrivate(Model model) {
        model.addAttribute("books", bookRepository.findByPrivateCatalogIsTrue().get());
        model.addAttribute("catalog", "Private Catalog");
        return "catalog";
    }

    @GetMapping("listPublic")
    public String listPublic(Model model) {
        model.addAttribute("books", bookRepository.findByPrivateCatalogIsFalse().get());
        model.addAttribute("catalog", "Public Catalog");
        return "catalog";
    }

    @PostMapping("add")
    public String addBook(@Validated Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookRepository.save(book);
        return "redirect:listAll";
    }

    @GetMapping("addForm")
    public String showAddForm(Book book) {
        return "add-book";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("update/{id}")
    public String updateBook(@PathVariable("id") long id, @Validated Book book, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
