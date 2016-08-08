package com.vegetarianbaconite.blueapi.beans;

import java.io.Serializable;

public class Team implements Serializable {

    String name;
    String location;
    String key;
    String nickname;
    String motto;
    int team_number;
    int rookie_year;

    public Team() {

    }

    public Team(String name, String location, String key, String nickname, String motto, int team_number, int rookie_year) {
        this.name = name;
        this.location = location;
        this.key = key;
        this.nickname = nickname;
        this.motto = motto;
        this.team_number = team_number;
        this.rookie_year = rookie_year;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", team_number, nickname);
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getTeamNumber() {
        return team_number;
    }

    public void setTeamNumber(int teamNumber) {
        this.team_number = teamNumber;
    }

    public int getRookieYear() {
        return rookie_year;
    }

    public void setRookieYear(int rookieYear) {
        this.rookie_year = rookieYear;
    }
}
