package com.mytask.library.DTO;


import com.mytask.library.model.BookTaken;

public class TakeBookRequest {
    private int readerfin;
    private String bookname;
    private int count;
    private BookTaken bookTaken;

    public int getReaderfin() {
        return readerfin;
    }

    public void setReaderfin(int readerfin) {
        this.readerfin = readerfin;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BookTaken getBookTaken() {
        return bookTaken;
    }

    public void setBookTaken(BookTaken bookTaken) {
        this.bookTaken = bookTaken;
    }
}
