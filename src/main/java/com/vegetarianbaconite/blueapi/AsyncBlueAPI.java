package com.vegetarianbaconite.blueapi;

import okhttp3.*;

import java.io.IOException;

public class AsyncBlueAPI {
    private static final String PREFIX = "http://www.thebluealliance.com/api/v2/";
    private static final String HEADER_KEY = "X-TBA-Auth-Key";
    private static final OkHttpClient c = new OkHttpClient();
    private String HEADER_VALUE;
    private BlueRequester requester;

    public AsyncBlueAPI(BlueRequester requester, String apiKey) {
        this.requester = requester;
        HEADER_VALUE = apiKey;
    }

    private void sendRequest(String urlBody) {
        final Request request = new Request.Builder()
                .url(PREFIX + urlBody)
                .addHeader(HEADER_KEY, HEADER_VALUE)
                .build();

        c.newCall(request).enqueue(forwardCallback);
    }

    private final Callback forwardCallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            requester.onError(e);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            requester.onResponse(response.body().string());
        }
    };

    /*
     * Team Requests
     */
    public void getTeamPage(int page) {
        sendRequest("teams/" + page);
    }

    public void getTeam(int teamNum) {
        sendRequest("team/frc" + teamNum);
    }

    public void getTeam(String teamKey) {
        sendRequest("team/" + teamKey);
    }

    public void getTeamEvents(int team) {
        sendRequest("team/frc" + team + "/events");
    }

    public void getTeamEvents(int team, int year) {
        sendRequest("team/frc" + team + "/" + year + "/events");
    }

    public void getTeamEventAwards(int team, String event) {
        sendRequest("team/frc" + team + "/event/" + event + "/awards");
    }

    public void getTeamEventMatches(int team, String event) {
        sendRequest("team/frc" + team + "/event/" + event + "/matches");
    }

    /*
     * Match Requests
     */

    public void getMatch(String comp, String match) {
        sendRequest("match/" + comp + "_" + match);
    }

    /*
     * Event Requests
     */
    public void getAllEvents(int year) {
        sendRequest("events/" + year);
    }

    public void getEvent(int year, String event) {
        sendRequest("event/" + year + event);
    }

    public void getEvent(String fullEventKey) {
        sendRequest("event/" + fullEventKey);
    }

    public void getEventTeams(int year, String event) {
        sendRequest("event/" + year + event + "/teams");
    }

    public void getEventMatches(int year, String event) {
        sendRequest("event/" + year + event + "/matches");
    }

    public void getEventStats(int year, String event) {
        sendRequest("event/" + year + event + "/stats");
    }

    public void getEventStats(String eventKey) {
        sendRequest("event/" + eventKey + "/stats");
    }

    public void getEventRankings(String eventKey) {
        sendRequest("event/" + eventKey + "/rankings");
    }

    public void getEventAwards(int year, String event) {
        sendRequest("event/" + year + event + "/awards");
    }

    /*
     * History Requests
     */
    public void getHistoryAwards(int team) {
        sendRequest("team/frc" + team + "/history/awards");
    }
}
