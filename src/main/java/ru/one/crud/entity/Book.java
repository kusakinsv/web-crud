package ru.one.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String author;

    private String release;

    private boolean privateCatalog;

    @JsonIgnore
    public String getCatalog() {
        if (privateCatalog) return "Private";
        else return "Public";
    }

    public boolean isPrivateCatalog() {
        return privateCatalog;
    }

    public void setPrivateCatalog(boolean isPrivate) {
        this.privateCatalog = isPrivate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", release='" + release + '\'' +
                ", isPrivate=" + privateCatalog +
                '}';
    }
}
