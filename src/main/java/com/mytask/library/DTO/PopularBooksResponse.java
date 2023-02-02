package com.mytask.library.DTO;

import com.mytask.library.model.PopBooks;

import java.util.List;

public class PopularBooksResponse {
    private int numFound;
    private int start;
    private List<PopBooks> docs;

    public PopularBooksResponse(int numFound, int start, List<PopBooks> docs) {
        this.numFound = numFound;
        this.start = start;
        this.docs = docs;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<PopBooks> getDocs() {
        return docs;
    }

    public void setDocs(List<PopBooks> docs) {
        this.docs = docs;
    }
}
