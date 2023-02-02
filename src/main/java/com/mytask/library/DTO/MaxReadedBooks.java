package com.mytask.library.DTO;

public class MaxReadedBooks {
    private String author_name;

    public MaxReadedBooks(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
