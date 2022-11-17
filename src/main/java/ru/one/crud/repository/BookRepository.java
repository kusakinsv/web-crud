package ru.one.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.one.crud.entity.Book;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findByPrivateCatalogIsTrue();
    Optional<List<Book>> findByPrivateCatalogIsFalse();
}
