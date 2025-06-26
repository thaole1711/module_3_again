package sevice;

import entity.Book;

import java.util.List;

public interface IBookSevice {
    List<Book> findAll();
    boolean addBook( Book book);
    boolean deleteBook(int id);
    boolean updateBook(Book book);
    Book findId(int id);
    List<Book> search( int id,String name);
}
