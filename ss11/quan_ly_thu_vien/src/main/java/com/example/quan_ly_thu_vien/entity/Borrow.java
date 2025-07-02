package com.example.quan_ly_thu_vien.entity;

public class Borrow {
    int borrow;
    int studentId;
    int bookId;
    String borrowDate;
    String returnDate;

    public Borrow(int borrow, int studentId, int bookId, String borrowDate, String returnDate) {
        this.borrow = borrow;
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBorrow() {
        return borrow;
    }

    public void setBorrow(int borrow) {
        this.borrow = borrow;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
