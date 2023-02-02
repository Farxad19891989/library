package com.mytask.library.DTO;

public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String fin;
    private String password;

    public RegisterRequest(String firstname, String lastname, String fin, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fin = fin;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
