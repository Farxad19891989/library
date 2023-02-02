package com.mytask.library.model;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private int ISBN;
    private String  bookname;
    private String  authorName;
    private Integer count;




    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<ReaderBook> readerBook;

    public Book(String bookname, String authorName, Integer count) {
        this.bookname = bookname;
        this.authorName = authorName;
        this.count = count;
    }

    public Book() {
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.category.getBookList().add(this);
    }
}
