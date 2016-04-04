package com.vegetarianbaconite.blueapi.beans;

public class Alliance {
    int score;
    String[] teams;

    public Alliance() {
    }

    public Alliance(int score, String[] teams) {
        this.score = score;
        this.teams = teams;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public Boolean contains(String teamKey) {
        for (String tk : teams) {
            if (tk.equals(teamKey)) return true;
        }

        return false;
    }
}
