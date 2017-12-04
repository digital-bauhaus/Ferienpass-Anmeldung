package de.jonashackt.springbootvuejs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sponsor_id;

    private String name;

    public Sponsor(){}

    public Sponsor(long sponsor_id, String name) {
        this.sponsor_id = sponsor_id;
        this.name = name;
    }

    public long getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(long sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}