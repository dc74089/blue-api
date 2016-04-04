package com.vegetarianbaconite.blueapi.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event implements Serializable {
    public static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String key;
    String name;
    String short_name;
    String districtString;
    String location;
    String start_date;
    int event_district;
    int event_type;

    public Event() {

    }

    public Event(String key, String name, String short_name, String districtString, String location, int event_district, int event_type, String start_date) {
        this.key = key;
        this.name = name;
        this.short_name = short_name;
        this.districtString = districtString;
        this.location = location;
        this.event_district = event_district;
        this.event_type = event_type;
        this.start_date = start_date;
    }

    public String getDate() {
        return start_date;
    }

    public void setDate(String start_date) {
        this.start_date = start_date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return short_name;
    }

    public void setShortName(String short_name) {
        this.short_name = short_name;
    }

    public String getDistrictString() {
        return districtString;
    }

    public void setDistrictString(String districtString) {
        this.districtString = districtString;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEvent_district() {
        return event_district;
    }

    public void setEvent_district(int event_district) {
        this.event_district = event_district;
    }

    public int getEvent_type() {
        return event_type;
    }

    public void setEvent_type(int event_type) {
        this.event_type = event_type;
    }

    public Boolean isPast() {
        try {
            Calendar start = Calendar.getInstance();
            start.setTime(df.parse(getDate()));

            Calendar threeAgo = Calendar.getInstance();
            threeAgo.add(Calendar.DATE, -4);

            return threeAgo.after(start);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        return true;
    }
}
