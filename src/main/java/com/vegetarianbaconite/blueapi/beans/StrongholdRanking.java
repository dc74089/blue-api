package com.vegetarianbaconite.blueapi.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrongholdRanking {
    public ArrayList<String> data;

    public enum Field {
        RANK(0),
        TEAM(1),
        RP(2),
        AUTO(3),
        SCALECHALLENGE(4),
        GOALS(5),
        DEFENSE(6),
        WINLOSSTIE(7),
        PLAYED(8);

        private final int position;

        Field(Integer position) {
            this.position = position;
        }

        public Integer getPosition() {
            return position;
        }
    }

    public StrongholdRanking() {
    }

    public StrongholdRanking(String[] d) {
        this.data = new ArrayList<>(Arrays.asList(d));
    }

    public static List<StrongholdRanking> rankingListFromArrays(String[][] s) {
        List<StrongholdRanking> l = new ArrayList<>();
        for (String[] d : s) {
            l.add(new StrongholdRanking(d));
        }
        return l;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public Boolean isHeader() {
        try {
            Integer.parseInt(data.get(0));
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public String getFieldString(Field f) {
        return data.get(f.getPosition());
    }

    public Integer getFieldInt(Field f) {
        return Integer.parseInt(data.get(f.getPosition()));
    }

    public static StrongholdRanking getRankingByField(List<StrongholdRanking> rankings, Field f, String value) {
        for (StrongholdRanking r : rankings) {
            if (r.getFieldString(f).equals(value)) {
                return r;
            }
        }

        return null;
    }
}
