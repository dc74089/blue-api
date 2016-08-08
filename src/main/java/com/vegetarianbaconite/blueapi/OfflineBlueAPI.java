package com.vegetarianbaconite.blueapi;

import com.google.gson.Gson;
import com.vegetarianbaconite.blueapi.beans.Event;
import com.vegetarianbaconite.blueapi.beans.Match;
import com.vegetarianbaconite.blueapi.beans.OfflineData;
import com.vegetarianbaconite.blueapi.beans.Team;

import java.io.FileReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfflineBlueAPI {
    private Gson g = new Gson();
    private OfflineData data;

    public OfflineBlueAPI(FileReader input) {
        try {
            data = g.fromJson(input, OfflineData.class);
        } catch (RuntimeException e) {
            throw new RuntimeException("There was a problem with the JSON you inputted.", e);
        }
    }

    public OfflineBlueAPI(OfflineData inputData) {
        data = inputData;
    }

    public static class CacheBuilder {
        private int cacheYear;
        private Boolean cacheTeams, cacheEvents, cacheMatches;
        private OfflineData data;
        private SyncronousBlueAPI api;

        public CacheBuilder(String publisher, String app, String version) {
            cacheYear = Calendar.getInstance().get(Calendar.YEAR);
            cacheTeams = cacheEvents = cacheMatches = false;
            data = new OfflineData();
            api = new SyncronousBlueAPI(publisher, app, version);
        }

        public CacheBuilder cacheFrom(int year) {
            if (year < 1992) throw new RuntimeException("Year must be greater than or equal to 1992 " +
                    "(the year of the first FRC competition)!");
            cacheYear = year;
            return this;
        }

        public CacheBuilder cacheTeams() {
            cacheTeams = true;
            return this;
        }

        public CacheBuilder cacheEvents() {
            cacheEvents = true;
            return this;
        }

        public CacheBuilder cacheMatches() {
            cacheEvents = true;
            cacheMatches = true;
            return this;
        }

        public OfflineData build() {
            if (cacheTeams) {
                System.out.println("Caching Teams");
                Map<Integer, Team> teamMap = new HashMap<>();
                for (Team t : api.getAllTeams()) {
                    teamMap.put(t.getTeamNumber(), t);
                }
                data.setTeams(teamMap);
            }

            if (cacheEvents) {
                System.out.println("Caching Events");
                Map<String, Event> map = new HashMap<>();
                for (int i = cacheYear; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
                    System.out.println(i);
                    for (Event e : api.getAllEvents(i)) {
                        map.put(e.getKey(), e);
                    }
                }
                data.setEvents(map);
            }

            if (cacheMatches) {
                System.out.println("Caching Matches (this will take awhile)");
                Map<String, List<Match>> keyMatchListMap = new HashMap<>();
                for (Event e : data.getEvents().values()) {
                    System.out.println(e.getKey());
                    try {
                        keyMatchListMap.put(e.getKey(), api.getEventMatches(e.getKey()));
                    } catch (NullPointerException ignored) {
                    }
                }
                data.setMatches(keyMatchListMap);
            }

            return data;
        }
    }

    public OfflineData getRawData() {
        return data;
    }

    public Team getTeam(Integer teamNo) {
        return data.getTeams().get(teamNo);
    }

    public Event getEvent(String key) {
        return data.getEvents().get(key);
    }

    public List<Match> getEventMatches(String eventKey) {
        return data.getMatches().get(eventKey);
    }
}
