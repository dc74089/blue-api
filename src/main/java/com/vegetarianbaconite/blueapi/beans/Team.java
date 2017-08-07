package com.vegetarianbaconite.blueapi.beans;

import java.io.Serializable;

public class Team implements Serializable {

    String key;
    Integer team_number;
    String nickname;
    String name;
    String state_prov;
    String country;
    String address;
    String postal_code;
    String gmaps_place_id;
    String gmaps_url;
    Double lat;
    Double lng;
    String location_name;
    String website;
    Integer rookie_year;
    String motto;

    public Team() {

    }

    public Team(String key, Integer team_number, String nickname, String name, String state_prov, String country, String address, String postal_code, String gmaps_place_id, String gmaps_url, Double lat, Double lng, String location_name, String website, Integer rookie_year, String motto) {
        this.key = key;
        this.team_number = team_number;
        this.nickname = nickname;
        this.name = name;
        this.state_prov = state_prov;
        this.country = country;
        this.address = address;
        this.postal_code = postal_code;
        this.gmaps_place_id = gmaps_place_id;
        this.gmaps_url = gmaps_url;
        this.lat = lat;
        this.lng = lng;
        this.location_name = location_name;
        this.website = website;
        this.rookie_year = rookie_year;
        this.motto = motto;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getTeam_number() {
        return team_number;
    }

    public void setTeam_number(Integer team_number) {
        this.team_number = team_number;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getRookie_year() {
        return rookie_year;
    }

    public void setRookie_year(Integer rookie_year) {
        this.rookie_year = rookie_year;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", team_number, nickname);
    }
}
