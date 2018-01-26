package de.jonashackt.ferienpassanmeldung.domain;

import javax.persistence.*;



@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long doctor_id;

    private String firstName;
    private String lastName;
    private String address;
    private String postcode;
    private String telephone;

    public Doctor() {}

    public Doctor(String firstName, String lastName, String address, String postcode, String telephone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postcode = postcode;
        this.telephone = telephone;
    }

    @Override
    public String toString(){
        return String.format(
                "Doctor[doctor_id=%d, firstName='%s',lastName='%s', address='%s', postcode='%s', telephone='%s']",
                doctor_id,firstName,lastName,address,postcode,telephone);
    }


    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
