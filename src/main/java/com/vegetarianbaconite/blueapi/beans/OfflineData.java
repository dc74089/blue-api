package com.vegetarianbaconite.blueapi.beans;

import java.util.List;
import java.util.Map;

public class OfflineData {
    public Map<Integer, Team> teams;
    public Map<String, Event> events;
    public Map<String, List<Match>> matches;

    public OfflineData() {
    }

    public OfflineData(Map<Integer, Team> teams, Map<String, Event> events, Map<String, List<Match>> matches) {
        this.teams = teams;
        this.events = events;
        this.matches = matches;
    }

    public Map<Integer, Team> getTeams() {
        return teams;
    }

    public void setTeams(Map<Integer, Team> teams) {
        this.teams = teams;
    }

    public Map<String, Event> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Event> events) {
        this.events = events;
    }

    public Map<String, List<Match>> getMatches() {
        return matches;
    }

    public void setMatches(Map<String, List<Match>> matches) {
        this.matches = matches;
    }
}
