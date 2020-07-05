package com.bebetterprogrammer.mugs.model;

public class Mugs {
    private int mug_id;
    private int user_id;
    private String mug_name;
    private int mug_money;
    private int is_fixed;
    private int add_by_percent;
    private int add_by_fixed;

    public Mugs(){}

    public Mugs(int mug_id, int user_id, String mug_name, int mug_money, int is_fixed, int add_by_percent, int add_by_fixed) {
        this.mug_id = mug_id;
        this.user_id = user_id;
        this.mug_name = mug_name;
        this.mug_money = mug_money;
        this.is_fixed = is_fixed;
        this.add_by_percent = add_by_percent;
        this.add_by_fixed = add_by_fixed;
    }

    public int getMug_id() {
        return mug_id;
    }

    public void setMug_id(int mug_id) {
        this.mug_id = mug_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMug_name() {
        return mug_name;
    }

    public void setMug_name(String mug_name) {
        this.mug_name = mug_name;
    }

    public int getMug_money() {
        return mug_money;
    }

    public void setMug_money(int mug_money) {
        this.mug_money = mug_money;
    }

    public int getIs_fixed() {
        return is_fixed;
    }

    public void setIs_fixed(int is_fixed) {
        this.is_fixed = is_fixed;
    }

    public int getAdd_by_percent() {
        return add_by_percent;
    }

    public void setAdd_by_percent(int add_by_percent) {
        this.add_by_percent = add_by_percent;
    }

    public int getAdd_by_fixed() {
        return add_by_fixed;
    }

    public void setAdd_by_fixed(int add_by_fixed) {
        this.add_by_fixed = add_by_fixed;
    }
}
