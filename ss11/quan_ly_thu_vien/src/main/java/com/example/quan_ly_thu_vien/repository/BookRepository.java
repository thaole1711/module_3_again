package com.example.quan_ly_thu_vien.repository;

import com.example.quan_ly_thu_vien.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private final String SELECT_ALL = "select * from books;";
    private final String INSERT_INTO = " INSERT INTO `quan_ly_thu_vien`.`books` (`title`, `page_size`, `id_category`, `id_author`) VALUES (?,?,?,?);";
    private final String DELETE_ID = "delete from books where id_book=?;";
    private final String UPDATE_ID = "update books set title=?,page_size=?,id_category=?,id_author=? where id_book=?;";
    private final String SELECT_ID = "select * from books where id_book=?;";
    private final String SELECT_SEARCH="select * from books where (id_category=? or ?=0) and (title=? or title like ?);";


    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("id_book");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                int idCategory = resultSet.getInt("id_category");
                int idAuthor = resultSet.getInt("id_author");
                bookList.add(new Book(bookId, title, pageSize, idCategory, idAuthor));
            }
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return bookList;
    }

    public boolean addBook(Book book) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPageSize());
            preparedStatement.setInt(3, book.getCategoryId());
            preparedStatement.setInt(4, book.getAuthorId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return false;


    }

    public boolean deleteBook(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ID)) {
            preparedStatement.setInt(1, id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối database");
        }
        return false;
    }

    public boolean updateBook(Book book) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID);) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPageSize());
            preparedStatement.setInt(3, book.getCategoryId());
            preparedStatement.setInt(4, book.getAuthorId());
            preparedStatement.setInt(5, book.getBookId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return false;

    }

    public Book findId(int id) {
        Book book = new Book();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book.setBookId(resultSet.getInt("id_book"));
                book.setTitle(resultSet.getString("title"));
                book.setPageSize(resultSet.getInt("page_size"));
                book.setCategoryId(resultSet.getInt("id_category"));
                book.setAuthorId(resultSet.getInt("id_authors"));

            }
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return book;
    }
    public List<Book> search( int id,String name){
        List<Book> list= new ArrayList<>();
        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SEARCH)) {
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,id);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int bookId = resultSet.getInt("id_book");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                int idCategory = resultSet.getInt("id_category");
                int idAuthor = resultSet.getInt("id_author");
                list.add(new Book(bookId, title, pageSize, idCategory, idAuthor));
            }
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return list;
    }
}
