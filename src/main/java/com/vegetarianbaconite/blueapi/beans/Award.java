package com.vegetarianbaconite.blueapi.beans;

public class Award {
    String name;
    int award_type;
    String event_key;
    String recipient;
    int year;

    public Award() {

    }

    public Award(String name, int award_type, String event, String recipient, int year) {
        this.name = name;
        this.award_type = award_type;
        this.event_key = event;
        this.recipient = recipient;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s, given to %s at %s", name, recipient, event_key);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAwardType() {
        return award_type;
    }

    public void setAwardType(int award_type) {
        this.award_type = award_type;
    }

    public String getEvent() {
        return event_key;
    }

    public void setEvent(String event) {
        this.event_key = event;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
