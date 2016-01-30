package com.example.shreyvalia.evently;

/**
 * Created by Jenna on 1/30/2016.
 */
public class node {
    String name;
    String description;
    // photos (optional)
    String address;
    private int date;
    private int sTime;
    private int eTime;
    private int nAttend;
    private int max;
    private int rating;
    private String userID;
    private boolean visible;

    public node(String userID) {
        this.userID = userID;
        int rating;
        String name;
        String description;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getsTime() {
        return this.sTime;
    }

    public void setsTime(int sTime) {
        this.sTime = sTime;
    }

    public int geteTime() {
        return this.eTime;
    }

    public void seteTime(int eTime) {
        this.eTime = eTime;
    }

    public int getnAttend() {
        return this.nAttend;
    }

    public void setnAttend(int nAttend) {
        this.nAttend = nAttend;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserID(){
        return this.userID;
    }

    public void setUserID(int UserID){
        this.userID = userID;
    }

    public boolean getVisible(){
        return this.visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

}

