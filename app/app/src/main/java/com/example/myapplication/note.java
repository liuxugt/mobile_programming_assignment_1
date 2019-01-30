package com.example.myapplication;

public class note {
    private String title;
    private String body;
    note(){
        title = "";
        body = "";
    }
    note(String T, String B){
        title = T;
        body = B;
    }

    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }
    public void setTitle(String T){
        title = T;
    }
    public void setBody(String B){
        body = B;
    }
}
