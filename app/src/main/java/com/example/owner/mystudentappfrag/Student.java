package com.example.owner.mystudentappfrag;

import android.graphics.Bitmap;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by owner on 11-Dec-16.
 */

public class Student {


    public Student(String name, int id, String phone, String address, int year, int month, int day, int hour, int minute) {
        this.name = name;
        Id = id;
        this.phone = phone;
        this.address = address;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    private String name;
    private int Id;
    private Boolean checked;
    private String phone;
    private String address;
    private Bitmap picture;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;



    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public Boolean getChecked() {
        return checked;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
