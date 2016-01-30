package com.example.shreyvalia.evently;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Jenna on 1/30/2016.
 */
public class node {
    String name;
    String description;
    // photos (optional)
    String address;
    private Date date;
    private Time sTime;
    private Time eTime;
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

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getsTime() {
        return this.sTime;
    }

    public void setsTime(Time sTime) {
        this.sTime = sTime;
    }

    public Time geteTime() {
        return this.eTime;
    }

    public void seteTime(Time eTime) {
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

