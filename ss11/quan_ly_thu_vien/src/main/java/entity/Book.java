package entity;

public class Book {
   int bookId;
   String title;
   int pageSize;
   int categoryId;
   int authorId;

    public Book(int bookId, String title, int pageSize, int categoryId, int authorId) {
        this.bookId = bookId;
        this.title = title;
        this.pageSize = pageSize;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book(String title, int pageSize, int categoryId, int authorId) {
        this.title = title;
        this.pageSize = pageSize;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
