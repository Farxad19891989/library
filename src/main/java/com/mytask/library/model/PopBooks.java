package com.mytask.library.model;

public class PopBooks {
    private String key;
    private String type;
    private String name;
    private String birth_date;
    private String top_work;

    public PopBooks(String key, String type, String name, String birth_date, String top_work) {
        this.key = key;
        this.type = type;
        this.name = name;
        this.birth_date = birth_date;
        this.top_work = top_work;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getTop_work() {
        return top_work;
    }

    public void setTop_work(String top_work) {
        this.top_work = top_work;
    }
}
