package com.vegetarianbaconite.blueapi.beans;

public class Award {
    String name;
    int award_type;
    String event_key;
    Recipient recipients[];
    int year;

    public Award() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward_type() {
        return award_type;
    }

    public void setAward_type(int award_type) {
        this.award_type = award_type;
    }

    public String getEvent_key() {
        return event_key;
    }

    public void setEvent_key(String event_key) {
        this.event_key = event_key;
    }

    public Recipient[] getRecipients() {
        return recipients;
    }

    public void setRecipients(Recipient[] recipients) {
        this.recipients = recipients;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public class Recipient {
        String team_key;
        String awardee;

        public Recipient() {
        }

        public String getTeam_key() {
            return team_key;
        }

        public void setTeam_key(String team_key) {
            this.team_key = team_key;
        }

        public String getAwardee() {
            return awardee;
        }

        public void setAwardee(String awardee) {
            this.awardee = awardee;
        }
    }
}
