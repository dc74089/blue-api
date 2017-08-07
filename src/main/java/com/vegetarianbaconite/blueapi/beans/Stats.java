package com.vegetarianbaconite.blueapi.beans;

import java.util.HashMap;

public class Stats {
    public HashMap<String, Double> oprs;
    public HashMap<String, Double> dprs;
    public HashMap<String, Double> ccwms;

    public Stats() {

    }

    public HashMap<String, Double> getOprs() {
        return oprs;
    }

    public void setOprs(HashMap<String, Double> oprs) {
        this.oprs = oprs;
    }

    public HashMap<String, Double> getDprs() {
        return dprs;
    }

    public void setDprs(HashMap<String, Double> dprs) {
        this.dprs = dprs;
    }

    public HashMap<String, Double> getCcwms() {
        return ccwms;
    }

    public void setCcwms(HashMap<String, Double> ccwms) {
        this.ccwms = ccwms;
    }
}
