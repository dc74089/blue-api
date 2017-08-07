package com.vegetarianbaconite.blueapi.beans;

public class Alliance {
    int score;
    String[] team_keys;
    String[] surrogate_team_keys;

    public Alliance() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getTeam_keys() {
        return team_keys;
    }

    public void setTeam_keys(String[] team_keys) {
        this.team_keys = team_keys;
    }

    public String[] getSurrogate_team_keys() {
        return surrogate_team_keys;
    }

    public void setSurrogate_team_keys(String[] surrogate_team_keys) {
        this.surrogate_team_keys = surrogate_team_keys;
    }

    public Boolean contains(String teamKey) {
        for (String tk : team_keys) {
            if (tk.equals(teamKey)) return true;
        }

        for (String tk : surrogate_team_keys) {
            if (tk.equals(teamKey)) return true;
        }

        return false;
    }
}
