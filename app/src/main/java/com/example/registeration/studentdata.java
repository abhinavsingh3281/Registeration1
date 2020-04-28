package com.example.registeration;


public class studentdata {
   String name,pass,ph,email;

    public studentdata(String name, String pass, String ph, String email) {
        this.name = name;
        this.pass = pass;
        this.ph = ph;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
