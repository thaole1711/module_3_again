package sevice;

import entity.Book;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;

public class BookSevice implements IBookSevice{
    private static IBookRepository iBookRepository= new BookRepository();
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public boolean addBook(Book book) {
        return iBookRepository.addBook(book);
    }

    @Override
    public boolean deleteBook(int id) {
        return iBookRepository.deleteBook(id);
    }

    @Override
    public boolean updateBook(Book book) {
        return iBookRepository.updateBook(book);
    }

    @Override
    public Book findId(int id) {
        return  iBookRepository.findId(id);
    }

    @Override
    public List<Book> search(int id,String name) {
        return iBookRepository.search(id,name);
    }
}