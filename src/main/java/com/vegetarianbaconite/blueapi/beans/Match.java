package com.vegetarianbaconite.blueapi.beans;

import java.util.Map;

public class Match {
    String key;
    String comp_level;
    Integer set_number;
    Integer match_number;
    Alliances alliances;
    String winning_alliance;
    String event_key;
    Integer time;
    Integer actual_time;
    Integer post_result_time;
    Map<String, Object> score_breakdown;
    Video videos[];

    public Match() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComp_level() {
        return comp_level;
    }

    public void setComp_level(String comp_level) {
        this.comp_level = comp_level;
    }

    public Integer getSet_number() {
        return set_number;
    }

    public void setSet_number(Integer set_number) {
        this.set_number = set_number;
    }

    public Integer getMatch_number() {
        return match_number;
    }

    public void setMatch_number(Integer match_number) {
        this.match_number = match_number;
    }

    public Alliances getAlliances() {
        return alliances;
    }

    public void setAlliances(Alliances alliances) {
        this.alliances = alliances;
    }

    public String getWinning_alliance() {
        return winning_alliance;
    }

    public void setWinning_alliance(String winning_alliance) {
        this.winning_alliance = winning_alliance;
    }

    public String getEvent_key() {
        return event_key;
    }

    public void setEvent_key(String event_key) {
        this.event_key = event_key;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getActual_time() {
        return actual_time;
    }

    public void setActual_time(Integer actual_time) {
        this.actual_time = actual_time;
    }

    public Integer getPost_result_time() {
        return post_result_time;
    }

    public void setPost_result_time(Integer post_result_time) {
        this.post_result_time = post_result_time;
    }

    public Map<String, Object> getScore_breakdown() {
        return score_breakdown;
    }

    public void setScore_breakdown(Map<String, Object> score_breakdown) {
        this.score_breakdown = score_breakdown;
    }

    public Video[] getVideos() {
        return videos;
    }

    public void setVideos(Video[] videos) {
        this.videos = videos;
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

    public class Video {
        String key;
        String type;
        String foreign_key;
        String preferred;
    }
}
