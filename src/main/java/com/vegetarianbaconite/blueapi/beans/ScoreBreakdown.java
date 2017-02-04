package com.vegetarianbaconite.blueapi.beans;

import java.util.Map;

public class ScoreBreakdown {
    Map<String, String> red;
    Map<String, String> blue;

    public ScoreBreakdown() {
    }

    public Map<String, String> getRed() {
        return red;
    }

    public void setRed(Map<String, String> red) {
        this.red = red;
    }

    public Map<String, String> getBlue() {
        return blue;
    }

    public void setBlue(Map<String, String> blue) {
        this.blue = blue;
    }
}
