package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.Disability;
import de.jonashackt.springbootvuejs.domain.Doctor;
import de.jonashackt.springbootvuejs.domain.Limitation;
import de.jonashackt.springbootvuejs.domain.Project;

import java.util.Date;
import java.util.List;

public class Formular {

    public Formular(){}

    public Formular (String firstname, String lastname){
        this.firstName = firstname;
        this.lastName  = lastname;
    }

    public long id;
    public String firstName;
    public String lastName;
    public Date birthdate;
    public String street;
    public String city;
    public String postcode;
    public String healthcareNr;
    public String telephone;
    public String emergencyContact;
    public boolean allowRide;
    public boolean allowSwim;
    public boolean allowHomeAlone;
    public Doctor doctor;
    public List<Project> projects;
    public List<Limitation> limitations;
    public List<Disability> disabilities;
}
