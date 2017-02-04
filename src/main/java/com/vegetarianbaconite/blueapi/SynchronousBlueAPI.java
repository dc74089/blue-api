package com.vegetarianbaconite.blueapi;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.vegetarianbaconite.blueapi.beans.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.*;

public class SynchronousBlueAPI {
    private static final String PREFIX = "http://www.thebluealliance.com/api/v2/";
    private static final String HEADER_KEY = "X-TBA-App-Id";
    private static final Gson g = new Gson();
    private final OkHttpClient c = new OkHttpClient();
    private String HEADER_VALUE;

    public SynchronousBlueAPI(String publisher, String app, String version) {
        HEADER_VALUE = publisher + ":" + app + ":" + version;
    }

    private String sendRequest(String urlBody) {
        final Request request = new Request.Builder()
                .url(PREFIX + urlBody)
                .addHeader(HEADER_KEY, HEADER_VALUE)
                .build();

        try {
            return c.newCall(request).execute().body().string();
        } catch (IOException e) {
            return null;
        }
    }

    /*
     * Team Requests
     */
    public List<Team> getTeamPage(int page) {
        Team[] teams = g.fromJson(sendRequest("teams/" + page), Team[].class);
        return new ArrayList<>(Arrays.asList(teams));
    }

    public List<Team> getAllTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            teams.addAll(getTeamPage(i));
        }
        return teams;
    }

    public Team getTeam(int teamNum) {
        return g.fromJson(sendRequest("team/frc" + teamNum), Team.class);
    }

    public Team getTeam(String teamKey) {
        return g.fromJson(sendRequest("team/" + teamKey), Team.class);
    }

    public List<Event> getTeamEvents(int team) {
        try {
            Event[] events = g.fromJson(sendRequest("team/frc" + team + "/events"), Event[].class);
            return new ArrayList<>(Arrays.asList(events));
        } catch (JsonSyntaxException e) {
            return new ArrayList<>(); //If team doesn't exist, return an empty List
        }
    }

    public List<Event> getTeamEvents(int team, int year) {
        try {
            Event[] events = g.fromJson(sendRequest("team/frc" + team + "/" + year + "/events"), Event[].class);
            return new ArrayList<>(Arrays.asList(events));
        } catch (JsonSyntaxException e) {
            return new ArrayList<>(); //If team doesn't exist, return an empty List
        }
    }

    public List<Award> getTeamEventAwards(int team, String event) {
        Award[] awards = g.fromJson(sendRequest("team/frc" + team + "/event/" + event + "/awards"), Award[].class);
        return new ArrayList<>(Arrays.asList(awards));
    }

    public List<Match> getTeamEventMatches(int team, String event) {
        Match[] matches = g.fromJson(sendRequest("team/frc" + team + "/event/" + event + "/matches"), Match[].class);
        return new ArrayList<>(Arrays.asList(matches));
    }

    /*
     * Match Requests
     */

    public Match getMatch(String comp, String match) {
        Match m = g.fromJson(sendRequest("match/" + comp + "_" + match), Match.class);
        return m;
    }

    /*
     * Event Requests
     */
    public List<Event> getAllEvents(int year) {
        Event[] events = g.fromJson(sendRequest("events/" + year), Event[].class);
        return new ArrayList<>(Arrays.asList(events));
    }

    public Event getEvent(int year, String event) {
        return g.fromJson(sendRequest("event/" + year + event), Event.class);
    }

    public Event getEvent(String eventKey) {
        return g.fromJson(sendRequest("event/" + eventKey), Event.class);
    }

    public List<Team> getEventTeams(int year, String event) {
        Team[] teams = g.fromJson(sendRequest("event/" + year + event + "/teams"), Team[].class);
        return new ArrayList<>(Arrays.asList(teams));
    }

    public List<Team> getEventTeams(String eventKey) {
        Team[] teams = g.fromJson(sendRequest("event/" + eventKey + "/teams"), Team[].class);
        return new ArrayList<>(Arrays.asList(teams));
    }

    public List<Match> getEventMatches(int year, String event) {
        Match[] matches = g.fromJson(sendRequest("event/" + year + event + "/matches"), Match[].class);
        return new ArrayList<>(Arrays.asList(matches));
    }

    public List<Match> getEventMatches(String eventKey) {
        Match[] matches = g.fromJson(sendRequest("event/" + eventKey + "/matches"), Match[].class);
        return new ArrayList<>(Arrays.asList(matches));
    }

    public Stats getEventStats(int year, String event) {
        return g.fromJson(sendRequest("event/" + year + event + "/stats"), Stats.class);
    }

    public Stats getEventStats(String eventKey) {
        return g.fromJson(sendRequest("event/" + eventKey + "/stats"), Stats.class);
    }

    public List<StrongholdRanking> getEventRankings(String eventKey) {
        Map<Integer, Integer> teamRankingMap = new HashMap<>();

        String[][] rankings = g.fromJson(sendRequest("event/" + eventKey + "/rankings"), String[][].class);

        return StrongholdRanking.rankingListFromArrays(rankings);
    }

    public List<Award> getEventAwards(int year, String event) {
        Award[] awards = g.fromJson(sendRequest("event/" + year + event + "/awards"), Award[].class);
        return new ArrayList<>(Arrays.asList(awards));
    }

    /*
     * History Requests
     */
    public List<Award> getHistoryAwards(int team) {
        Award[] awards = g.fromJson(sendRequest("team/frc" + team + "/history/awards"), Award[].class);
        return new ArrayList<>(Arrays.asList(awards));
    }
}
