package de.jonashackt.springbootvuejs.controller;

class PrivUser {

    private String first_name;
    private String last_name;
    private Integer id;
    private String state;

    public PrivUser(){}

    public PrivUser(String fname, String lname, Integer id) {
        this.first_name = fname;
        this.last_name  = lname;
        this.id         = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public Integer getId() {
        return id;
    }

    public String getState() { return state; }
}


