package com.mytask.library.DTO;

public class ReaderRequest {

    private String readerName;

    public ReaderRequest(int fin, String readerName) {
        this.readerName = readerName;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }
}
