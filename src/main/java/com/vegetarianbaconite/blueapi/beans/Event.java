package com.vegetarianbaconite.blueapi.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event implements Serializable {
    public static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String key;
    String name;
    String event_code;
    Integer event_type;
    District district;
    String city;
    String state_prov;
    String country;
    String start_date;
    String end_date;
    Integer year;
    String short_name;
    String event_type_string;
    Integer week;
    String address;
    String postal_code;
    String gmaps_place_id;
    String gmaps_url;
    Double lat;
    Double lng;
    String location_name;
    String timezone;
    String website;
    Integer first_event_id;
    Webcast webcasts[];
    String division_keys[];
    String parent_event_key;
    Integer playoff_type;
    String playoff_type_string;

    public Event() {

    }

    public static SimpleDateFormat getDf() {
        return df;
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

    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public Integer getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Integer event_type) {
        this.event_type = event_type;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_prov() {
        return state_prov;
    }

    public void setState_prov(String state_prov) {
        this.state_prov = state_prov;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getEvent_type_string() {
        return event_type_string;
    }

    public void setEvent_type_string(String event_type_string) {
        this.event_type_string = event_type_string;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getGmaps_place_id() {
        return gmaps_place_id;
    }

    public void setGmaps_place_id(String gmaps_place_id) {
        this.gmaps_place_id = gmaps_place_id;
    }

    public String getGmaps_url() {
        return gmaps_url;
    }

    public void setGmaps_url(String gmaps_url) {
        this.gmaps_url = gmaps_url;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getFirst_event_id() {
        return first_event_id;
    }

    public void setFirst_event_id(Integer first_event_id) {
        this.first_event_id = first_event_id;
    }

    public Webcast[] getWebcasts() {
        return webcasts;
    }

    public void setWebcasts(Webcast[] webcasts) {
        this.webcasts = webcasts;
    }

    public String[] getDivision_keys() {
        return division_keys;
    }

    public void setDivision_keys(String[] division_keys) {
        this.division_keys = division_keys;
    }

    public String getParent_event_key() {
        return parent_event_key;
    }

    public void setParent_event_key(String parent_event_key) {
        this.parent_event_key = parent_event_key;
    }

    public Integer getPlayoff_type() {
        return playoff_type;
    }

    public void setPlayoff_type(Integer playoff_type) {
        this.playoff_type = playoff_type;
    }

    public String getPlayoff_type_string() {
        return playoff_type_string;
    }

    public void setPlayoff_type_string(String playoff_type_string) {
        this.playoff_type_string = playoff_type_string;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", key, name);
    }

    public Boolean isPast() {
        try {
            Calendar start = Calendar.getInstance();
            start.setTime(df.parse(getEnd_date()));

            Calendar threeAgo = Calendar.getInstance();
            threeAgo.add(Calendar.DATE, -4);

            return threeAgo.after(start);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        return true;
    }

    public class District {
        String abbreviation;
        String display_name;
        String key;
        Integer year;

        public District() {
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }
    }

    public class Webcast {
        String type;
        String channel;
        String file;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }
}
