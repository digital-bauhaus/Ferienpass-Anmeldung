package de.jonashackt.springbootvuejs.domain;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "[User]")
public class    User {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String birthDate;
    private String postcode;
    private String street;
    private String city;
    private String telephone;
    private String healthcareNr;
    private Date registrationDate;
    private String registerDateString;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "contact_id")
    private Contact contact;

    private boolean allowTreatment;
    private boolean allowRiding;
    private boolean allowSwimming;
    private boolean allowHomeAlone;
    private boolean hasPayed;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToMany
    @JoinTable(

            name="user_project",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="project_id", referencedColumnName="project_id"))
    private List<Project> projects;

        @ManyToMany
        @JoinTable(
                name="userDisability",
                joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
                inverseJoinColumns=@JoinColumn(name="disability_id", referencedColumnName="disability_id"))
        private List<Disability> disabilities;

    @ManyToMany
    @JoinTable(
            name="userLimitation",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="limitation_id", referencedColumnName="limitation_id"))
    private List<Limitation> limitations;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String birthDate, String registerDateString, String street, String city, String postcode,
                String telephone, String healthcareNr, Contact contact,
                boolean allowTreatment, boolean allowRiding, boolean allowSwimming, boolean allowHomeAlone,
                boolean hasPayed, Doctor doctor, List<Project> projects, List<Limitation> limitations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.postcode = postcode;
        this.street = street;
        this.city = city;
        this.telephone = telephone;
        this.healthcareNr = healthcareNr;
        this.registrationDate = registrationDate;
        this.registerDateString = registerDateString;
        this.contact = contact;
        this.allowTreatment = allowTreatment;
        this.allowRiding = allowRiding;
        this.allowSwimming = allowSwimming;
        this.allowHomeAlone = allowHomeAlone;
        this.hasPayed = hasPayed;
        this.doctor = doctor;
        this.projects = projects;
        this.limitations = limitations;
    }

    @java.lang.Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", postcode='" + postcode + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", healthcareNr='" + healthcareNr + '\'' +
                ", registrationDate=" + registrationDate +
                ", registerDateString='" + registerDateString + '\'' +
                ", contact=" + contact +
                ", allowTreatment=" + allowTreatment +
                ", allowRiding=" + allowRiding +
                ", allowSwimming=" + allowSwimming +
                ", allowHomeAlone=" + allowHomeAlone +
                ", hasPayed=" + hasPayed +
                ", doctor=" + doctor +
                ", projects=" + projects +
                ", limitations=" + limitations +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostcode() {return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHealthcareNr() {
        return healthcareNr;
    }

    public void setHealthcareNr(String healthcareNr) {
        this.healthcareNr = healthcareNr;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean isAllowRiding() {
        return allowRiding;
    }

    public void setAllowRiding(boolean allowRiding) {
        this.allowRiding = allowRiding;
    }

    public Date getRegistrationDate() { return registrationDate; }

    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    public String getRegisterDateString() { return registerDateString; }

    public void setRegisterDateString(String registerDateString) { this.registerDateString = registerDateString; }

    public boolean isAllowSwimming() {
        return allowSwimming;
    }

    public void setAllowSwimming(boolean allowSwimming) {
        this.allowSwimming = allowSwimming;
    }

    public boolean isAllowHomeAlone() {
        return allowHomeAlone;
    }

    public void setAllowHomeAlone(boolean allowHomeAlone) {
        this.allowHomeAlone = allowHomeAlone;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isHasPayed() { return hasPayed; }

    public void setHasPayed(boolean hasPayed) { this.hasPayed = hasPayed; }

    public boolean isAllowTreatment() { return allowTreatment; }

    public void setAllowTreatment(boolean allowTreatment) { this.allowTreatment = allowTreatment; }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Disability> getDisabilities() { return disabilities; }

    public void setDisabilities(List<Disability> disabilities) { this.disabilities = disabilities; }

    public List<Limitation> getLimitations() {
        return limitations;
    }

    public void setLimitations(List<Limitation> limitations) {
        this.limitations = limitations;
    }

}
