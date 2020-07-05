package com.bebetterprogrammer.mugs.model;

public class History {

    private int history_id;
    private int user_id;
    private int mug_id;
    private int amount;
    private String spent_on;
    private int is_detected;
    private String date_time;

    public History(){}

    public History(int history_id, int user_id, int mug_id, int amount, String spent_on, int is_detected, String date_time) {
        this.history_id = history_id;
        this.user_id = user_id;
        this.mug_id = mug_id;
        this.amount = amount;
        this.spent_on = spent_on;
        this.is_detected = is_detected;
        this.date_time = date_time;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMug_id() {
        return mug_id;
    }

    public void setMug_id(int mug_id) {
        this.mug_id = mug_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSpent_on() {
        return spent_on;
    }

    public void setSpent_on(String spent_on) {
        this.spent_on = spent_on;
    }

    public int getIs_detected() {
        return is_detected;
    }

    public void setIs_detected(int is_detected) {
        this.is_detected = is_detected;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
