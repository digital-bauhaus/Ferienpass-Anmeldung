package de.jonashackt.springbootvuejs.domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class User {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private Date birthdate;
    private String address;
    private String telephone;
    private String healthcareNr;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "contact_id")
    private Contact emergencyContact;

    private boolean allowTreatment;
    private boolean allowRide;
    private boolean allowSwim;
    private boolean allowHomeAlone;
    private boolean isPaid;

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

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, Date birthdate,
                String address, String telephone, String healthcareNr, Contact emergencyContact,
                boolean allowTreatment, boolean allowRide, boolean allowSwim, boolean allowHomeAlone, boolean isPaid,
                Doctor doctor, List<Project> projects, List<Disability> disabilities, List<Limitation> limitations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.telephone = telephone;
        this.healthcareNr = healthcareNr;
        this.emergencyContact = emergencyContact;
        this.allowTreatment = allowTreatment;
        this.allowRide = allowRide;
        this.allowSwim = allowSwim;
        this.allowHomeAlone = allowHomeAlone;
        this.isPaid = isPaid;
        this.doctor = doctor;
        this.projects = projects;
        this.disabilities = disabilities;
        this.limitations = limitations;
    }

    /*
        public User(long id, String firstName, String lastName, Date birthdate, String street, String city, String postcode,
                    String telephone, String healthcareNr, String emergencyContact, boolean allowRide,
                    boolean allowSwim, boolean allowHomeAlone, boolean is_paid) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthdate = birthdate;
            this.street = street;
            this.city = city;
            this.postcode = postcode;
            this.telephone = telephone;
            this.healthcareNr = healthcareNr;
            this.emergencyContact = emergencyContact;
            this.allowRide = allowRide;
            this.allowSwim = allowSwim;
            this.allowHomeAlone = allowHomeAlone;
            this.isPaid = is_paid;
        }
    */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", healthcareNr='" + healthcareNr + '\'' +
                ", allowTreatment='" + allowTreatment +  '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", allowHomeAlone=" + allowHomeAlone +
                ", allowRide=" + allowRide +  '\'' +
                ", allowSwim=" + allowSwim +  '\'' +
                ", doctor=" + doctor + '\'' +
                ", projects=" + projects + '\'' +
                ", limitations=" + limitations + '\'' +
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

    public Contact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Contact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public boolean isAllowRide() {
        return allowRide;
    }

    public void setAllowRide(boolean allowRide) {
        this.allowRide = allowRide;
    }

    public boolean isAllowSwim() {
        return allowSwim;
    }

    public void setAllowSwim(boolean allowSwim) {
        this.allowSwim = allowSwim;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Disability> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<Disability> disabilities) {
        this.disabilities = disabilities;
    }

    public List<Limitation> getLimitations() {
        return limitations;
    }

    public void setLimitations(List<Limitation> limitations) {
        this.limitations = limitations;
    }

}
