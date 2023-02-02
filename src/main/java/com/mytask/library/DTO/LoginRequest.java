package com.mytask.library.DTO;

public class LoginRequest {
    private String fin;
    private String password;

    public LoginRequest(String fin, String password) {
        this.fin = fin;
        this.password = password;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
