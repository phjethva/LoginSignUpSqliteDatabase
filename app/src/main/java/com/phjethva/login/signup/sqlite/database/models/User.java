/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.models;

public class User {

    private int id;
    private String un, ei, pw;

    public User(){
    }

    public User(String un, String ei, String pw) {
        this.un = un;
        this.ei = ei;
        this.pw = pw;
    }

    public User(int id, String un, String ei, String pw) {
        this.id = id;
        this.un = un;
        this.ei = ei;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getEi() {
        return ei;
    }

    public void setEi(String ei) {
        this.ei = ei;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}