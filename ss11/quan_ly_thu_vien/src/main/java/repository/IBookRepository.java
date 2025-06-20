package repository;

import entity.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> findAll();
}
