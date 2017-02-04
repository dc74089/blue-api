package com.vegetarianbaconite.blueapi.beans;

public class Match {
    String key;
    String time_string;
    String comp_level;
    String event_key;
    Alliances alliances;
    int match_number;
    ScoreBreakdown score_breakdown;

    public class Alliances {
        Alliance red;
        Alliance blue;

        public Alliances() {

        }

        public Alliances(Alliance red, Alliance blue) {
            this.red = red;
            this.blue = blue;
        }

        public Alliance getRed() {
            return red;
        }

        public void setRed(Alliance red) {
            this.red = red;
        }

        public Alliance getBlue() {
            return blue;
        }

        public void setBlue(Alliance blue) {
            this.blue = blue;
        }
    }

    public Match() {

    }

    @Override
    public String toString() {
        String compLevelString;
        switch (comp_level) {
            case "qm":
                compLevelString = "qualifier";
                break;
            case "ef":
                compLevelString = "Einstein Final";
                break;
            case "qf":
                compLevelString = "Quarter Final";
                break;
            case "sf":
                compLevelString = "Semi Final";
                break;
            case "f":
                compLevelString = "Final";
                break;
            default:
                compLevelString = "Unknown Competition Level";
                break;
        }

        return String.format("%s match number %d at %s", compLevelString, match_number, event_key);
    }

    public boolean hasFinished() {
        return (this.alliances.red.getScore() != 0 || this.alliances.blue.getScore() != 0);
    }

    public Alliance allianceOfTeam(String teamKey) {
        for (String tk : alliances.red.getTeams()) {
            if (tk.equals(teamKey)) return alliances.red;
        }

        for (String tk : alliances.blue.getTeams()) {
            if (tk.equals(teamKey)) return alliances.blue;
        }

        return null;
    }

    public Alliance allianceOpposingTeam(String teamKey) {
        for (String tk : alliances.red.getTeams()) {
            if (tk.equals(teamKey)) return alliances.blue;
        }

        for (String tk : alliances.blue.getTeams()) {
            if (tk.equals(teamKey)) return alliances.red;
        }

        return null;
    }

    public Boolean teamIsRed(String teamKey) {
        for (String tk : alliances.red.getTeams()) {
            if (tk.equals(teamKey)) return true;
        }

        for (String tk : alliances.blue.getTeams()) {
            if (tk.equals(teamKey)) return false;
        }

        return null;
    }

    public Alliance getWinningAlliance() {
        if (alliances.red.getScore() == alliances.blue.getScore()) return null;
        return (alliances.red.getScore() > alliances.blue.getScore()) ? alliances.red : alliances.blue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTimeString() {
        return time_string;
    }

    public void setTimeString(String time_string) {
        this.time_string = time_string;
    }

    public String getCompLevel() {
        return comp_level;
    }

    public void setCompLevel(String comp_level) {
        this.comp_level = comp_level;
    }

    public String getEventKey() {
        return event_key;
    }

    public void setEventKey(String event_key) {
        this.event_key = event_key;
    }

    public Alliances getAlliances() {
        return alliances;
    }

    public void setAlliances(Alliances alliances) {
        this.alliances = alliances;
    }

    public int getMatchNumber() {
        return match_number;
    }

    public void setMatchNumber(int match_number) {
        this.match_number = match_number;
    }

    public void setScoreBreakdown(ScoreBreakdown score_breakdown) {
        this.score_breakdown = score_breakdown;
    }

    public ScoreBreakdown getScoreBreakdown() {
        return score_breakdown;
    }
}
