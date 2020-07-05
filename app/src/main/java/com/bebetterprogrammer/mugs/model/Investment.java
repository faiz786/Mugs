package com.bebetterprogrammer.mugs.model;

public class Investment {

    private int invest_id;
    private int user_id;
    private int invest_amount;
    private String invest_on;
    private String date_time;

    public Investment(){}

    public Investment(int invest_id, int user_id, int invest_amount, String invest_on, String date_time) {
        this.invest_id = invest_id;
        this.user_id = user_id;
        this.invest_amount = invest_amount;
        this.invest_on = invest_on;
        this.date_time = date_time;
    }

    public int getInvest_id() {
        return invest_id;
    }

    public void setInvest_id(int invest_id) {
        this.invest_id = invest_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getInvest_amount() {
        return invest_amount;
    }

    public void setInvest_amount(int invest_amount) {
        this.invest_amount = invest_amount;
    }

    public String getInvest_on() {
        return invest_on;
    }

    public void setInvest_on(String invest_on) {
        this.invest_on = invest_on;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
