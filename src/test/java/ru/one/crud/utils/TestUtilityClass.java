package ru.one.crud.utils;

import ru.one.crud.entity.Book;

public class TestUtilityClass {
    protected static long testId;

    public static Book createTestBook() {
        Book book = new Book();
        book.setName("Тестовая книга");
        book.setAuthor("Тестовый автор");
        book.setRelease("2022");
        book.setPrivateCatalog(true);
        return book;
    }

    public static long getTestId() {
        return testId;
    }

    public static void setTestId(long testId) {
        TestUtilityClass.testId = testId;
    }
}
