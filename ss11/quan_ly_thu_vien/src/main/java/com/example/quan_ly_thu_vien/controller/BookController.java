package com.example.quan_ly_thu_vien.controller;


import com.example.quan_ly_thu_vien.entity.Book;
import com.example.quan_ly_thu_vien.entity.Category;
import com.example.quan_ly_thu_vien.sevice.BookSevice;
import com.example.quan_ly_thu_vien.sevice.CategorySevice;
import com.example.quan_ly_thu_vien.sevice.IBookSevice;
import com.example.quan_ly_thu_vien.sevice.ICategorySevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;
import static java.nio.file.Files.delete;
import static jdk.internal.editor.external.ExternalEditor.edit;
import static jdk.jfr.internal.consumer.EventLog.update;

@WebServlet(urlPatterns = "/book")
public class BookController extends HttpServlet {
    private static IBookSevice iBookSevice = new BookSevice();
    private static ICategorySevice iCategorySevice = new CategorySevice();
    List<Category> categories = iCategorySevice.findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
            default:
                List<Book> bookList = iBookSevice.findAll();
                req.setAttribute("category", categories);
                req.setAttribute("books", bookList);
                req.getRequestDispatcher("/WEB-INF/view/book.jsp").forward(req, resp);
        }

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("categoryId");
        int id_search = (paramId == null || paramId.isEmpty()) ? 0 : Integer.parseInt(paramId);
        String name_search = req.getParameter("name");
        List<Book> bookLists = iBookSevice.search(id_search, name_search);
        req.setAttribute("books", bookLists);
        req.setAttribute("category", categories);
        req.getRequestDispatcher("/WEB-INF/view/book.jsp").forward(req, resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = iBookSevice.findId(id);
        if(book==null){
            resp.sendRedirect("/book?mess= id not found");
        }else {
            req.setAttribute("category", categories);
            req.setAttribute("book", book);
            req.getRequestDispatcher("/WEB-INF/view/updateBook.jsp").forward(req, resp);
        }
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("category", categories);
        req.getRequestDispatcher("/WEB-INF/view/addBook.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(req,resp);

                break;
            case "delete":
                delete(req,resp);

                break;
            case "update":
                edit(req,resp);

                break;
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idBook = Integer.parseInt(req.getParameter("id"));
        String title1 = req.getParameter("title");
        int page = Integer.parseInt(req.getParameter("pageSize"));
        int category = Integer.parseInt(req.getParameter("categoryId"));
        int author = Integer.parseInt(req.getParameter("authorId"));
        Book book1 = new Book(idBook, title1, page, category, author);
        iBookSevice.updateBook(book1);
        resp.sendRedirect("/book?mess=update success");

    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDelete = Integer.parseInt(req.getParameter("deleteId"));
        Book book = iBookSevice.findId(idDelete);
        if(book==null){
            resp.sendRedirect("/book?mess= id not found");
        }else {
            iBookSevice.deleteBook(idDelete);
            resp.sendRedirect("book?mess=delete success");
        }
    }
    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Book book = new Book(title, pageSize, categoryId, authorId);
        iBookSevice.addBook(book);
        resp.sendRedirect("book?mess=add success");
    }
}
