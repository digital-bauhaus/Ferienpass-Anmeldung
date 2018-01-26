package de.jonashackt.ferienpassanmeldung.domain;

import javax.persistence.*;

@Entity
public class Contact {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contact_id;

    private String name;
    private String address;
    private String postcode;
    private String telephone;

    public  Contact() {}

    public Contact(String name, String address, String postcode, String telephone) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.telephone = telephone;
    }

    @Override
    public String toString(){
        return String.format(
                "Contact[contact_id=%d, name='%s', address='%s', postcode='%s' , telephone='%s']",
                contact_id,name,address,postcode,telephone);
    }

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
