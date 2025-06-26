package controller;


import entity.Book;
import entity.Category;
import sevice.BookSevice;
import sevice.CategorySevice;
import sevice.IBookSevice;
import sevice.ICategorySevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/book")
public class BookController extends HttpServlet {
    private static IBookSevice iBookSevice = new BookSevice();
    private static ICategorySevice iCategorySevice= new CategorySevice();
    List<Category> categories= iCategorySevice.findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                req.setAttribute("category",categories);
                req.getRequestDispatcher("view/addBook.jsp").forward(req,resp);
                break;
            case "update":
                int id= Integer.parseInt(req.getParameter("id"));
                Book book=iBookSevice.findId(id);
                req.setAttribute("category", categories);
                req.setAttribute("book",book);
                req.getRequestDispatcher("/view/updateBook.jsp").forward(req,resp);
                break;
            case "search":
                String paramId=req.getParameter("categoryId");
                int id_search=(paramId==null||paramId.isEmpty())?0:Integer.parseInt(paramId);
                String name_search=req.getParameter("name");
               List<Book> bookLists= iBookSevice.search(id_search,name_search);
               req.setAttribute("books",bookLists);
                req.setAttribute("category",categories);
                req.getRequestDispatcher("view/book.jsp").forward(req, resp);
                break;
            default:
                List<Book> bookList = iBookSevice.findAll();
                req.setAttribute("category",categories);
                req.setAttribute("books", bookList);
                req.getRequestDispatcher("view/book.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                String title=req.getParameter("title");
                int pageSize= Integer.parseInt(req.getParameter("pageSize"));
                int categoryId= Integer.parseInt(req.getParameter("categoryId"));
                int authorId= Integer.parseInt(req.getParameter("authorId"));
                Book book= new Book(title,pageSize,categoryId,authorId);
                iBookSevice.addBook(book);
                resp.sendRedirect("book?mess=add success");
                break;
            case "delete":
                int idDelete= Integer.parseInt(req.getParameter("deleteId"));
                iBookSevice.deleteBook(idDelete);
                resp.sendRedirect("book?mess=delete success");
                break;
            case "update":
                int idBook= Integer.parseInt(req.getParameter("id"));
                String title1=req.getParameter("title");
                int page= Integer.parseInt(req.getParameter("pageSize"));
                int category= Integer.parseInt(req.getParameter("categoryId"));
                int author= Integer.parseInt(req.getParameter("authorId"));
                Book book1= new Book(idBook,title1,page,category,author);
                iBookSevice.updateBook(book1);
                resp.sendRedirect("/book?mess=update success");

                break;
        }
    }
}
