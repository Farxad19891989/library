package com.mytask.library.DTO;


import com.mytask.library.model.BookTaken;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class TakeBookResponse {
    private int book_id;
    private int reader_id;
    private int count;

    @Enumerated(EnumType.STRING)
    private BookTaken bookTaken;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
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
