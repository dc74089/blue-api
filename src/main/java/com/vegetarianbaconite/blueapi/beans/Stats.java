package com.vegetarianbaconite.blueapi.beans;

import java.util.HashMap;

public class Stats {
    public HashMap<Integer, Double> oprs;
    public HashMap<Integer, Double> dprs;
    public HashMap<Integer, Double> ccwms;

    public Stats() {

    }

    public Stats(HashMap<Integer, Double> oprs, HashMap<Integer, Double> dprs, HashMap<Integer, Double> ccwms) {
        this.oprs = oprs;
        this.dprs = dprs;
        this.ccwms = ccwms;
    }

    public HashMap<Integer, Double> getOprs() {
        return oprs;
    }

    public void setOprs(HashMap<Integer, Double> oprs) {
        this.oprs = oprs;
    }

    public HashMap<Integer, Double> getDprs() {
        return dprs;
    }

    public void setDprs(HashMap<Integer, Double> dprs) {
        this.dprs = dprs;
    }

    public HashMap<Integer, Double> getCcwms() {
        return ccwms;
    }

    public void setCcwms(HashMap<Integer, Double> ccwms) {
        this.ccwms = ccwms;
    }
}
