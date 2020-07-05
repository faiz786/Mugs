package com.bebetterprogrammer.mugs.model;

public class Users {
    private String user_id;
    private String full_name;
    private int salary;

    public Users(){}

    public Users(String user_id, String full_name, int salary) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.salary = salary;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
