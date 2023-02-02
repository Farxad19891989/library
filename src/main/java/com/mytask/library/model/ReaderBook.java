package com.mytask.library.model;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reader_book")
public class ReaderBook {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id",referencedColumnName = "ISBN")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reader_id",referencedColumnName = "fin")
    private Reader reader;

    private int count;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private BookTaken bookTaken;

    public BookTaken getBookTaken() {
        return bookTaken;
    }

    public void setBookTaken(BookTaken bookTaken) {
        this.bookTaken = bookTaken;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
