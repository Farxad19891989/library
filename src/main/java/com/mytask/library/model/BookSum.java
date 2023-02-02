package com.mytask.library.model;

public class BookSum {
    private String author_name;
    private Long count;

    public BookSum(String name, Long total) {
        this.author_name = name;
        this.count = total;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
