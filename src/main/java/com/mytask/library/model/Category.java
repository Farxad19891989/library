package com.mytask.library.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String category_name;
    @JsonIgnore
   @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Book> bookList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
