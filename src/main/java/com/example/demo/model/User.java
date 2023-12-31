package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String username;
    private String password;
    private String emailAddress;
    private ArrayList<Float> WPM;
    private float averageWPM;
    private float bestWPM;
    private LocalDate registerDate;
    private LocalDate lastLoginDate;
    

    public User() {
    }

    public User(String username, String password, String emailAddress) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.WPM = new ArrayList<Float>();
        this.averageWPM = 0;
        this.bestWPM = 0;
        this.lastLoginDate=null;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Float> getWPM() {
        return WPM;
    }

    public void setWPM(ArrayList<Float> wpm) {
        this.WPM = wpm;
    }

    public float getAverageWPM() {
        return averageWPM;
    }

    public void setAverageRecord(float averageWPM) {
        this.averageWPM = averageWPM;
    }

    public float getBestWPM() {
        return bestWPM;
    }

    public void setBestWPM(float bestWPM) {
        this.bestWPM = bestWPM;
    }

    public void addRecords(float wpm) {
        this.WPM.add(wpm);
        this.bestWPM = wpm;
        float sumTime = 0;
        for (int i = 0; i < WPM.size(); i++) {
            if (bestWPM < WPM.get(i)) {
                bestWPM = WPM.get(i);
            }
            sumTime += WPM.get(i);
        }
        averageWPM = sumTime / WPM.size();
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    
}
