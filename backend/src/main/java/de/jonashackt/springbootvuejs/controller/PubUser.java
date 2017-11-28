package de.jonashackt.springbootvuejs.controller;


public class PubUser {

    public PubUser(){}

    public PubUser (String firstname, String lastname, Integer id, String state){
        this.firstname = firstname;
        this.lastname  = lastname;
        this.id        = id;
        this.state     = state;
    }

    public String    firstname;
    public String    lastname;
    public Integer   id;
    public String    state;
}

