package com.mytask.library.model;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue
    private int fin;
    private String name;


    @OneToMany(mappedBy = "reader",cascade = CascadeType.ALL)
    private List<ReaderBook> readerBook;


    public Reader(int fin, String name) {
        this.fin = fin;
        this.name = name;
    }

    public Reader() {

    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
