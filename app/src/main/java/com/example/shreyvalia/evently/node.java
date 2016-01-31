package com.example.shreyvalia.evently;

import java.util.ArrayList;

/**
 * Created by Jenna on 1/30/2016.
 */
public class node {
    String name;
    String description;
    // photos (optional)
    String address;
//    private String startDate;
//    private String endDate;
//    private String startTime;
//    private String endTime;
    private String startDate_Time; //format is ("dd-MM-yyyy hh:mm:ss a")
    private String endDate_Time; //format is ("dd-MM-yyyy hh:mm:ss a")
    private int nAttend;
    private int max;
    private int rating;
    private String userID;
    private boolean visible;

    private static ArrayList<String> userIDResponded;

    public node(String userID) {
            this.userID = userID;
            int rating = 0;
            userIDResponded = new ArrayList<String>();
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

    public void setStartDate_Time(String startDate_time) {
        this.startDate_Time = startDate_time;
    }

    public String getStartDate_Time(){
        return startDate_Time;
    }

    public void setEndDate_Time(String endDate_time){
            this.endDate_Time = endDate_time;
    }

    public String getEndDate_Time(){
        return endDate_Time;
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

    public ArrayList getUserIDResponded(){
        return userIDResponded;
    }

    public void insertUserID(String new_userID){
        userIDResponded.add(new_userID);
    }
    public boolean userIDResponded(String token){
//        TODO: binary search too see if token is in userIDResponded.
        for(int i = 0; i < userIDResponded.size(); i++){
            if(userIDResponded.get(i) == token){
                return true;
            }
        }
        return false;
    }
//    public
    
}

