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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long project_id;

    private String name;
    private int slots;
    private int reservedSlots;
    private String weblink;
    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private Sponsor sponsor;

    private Project(){}

    public Project(String name, int slots, int reservedSlots, String weblink, Sponsor sponsor) {
        this.name = name;
        this.slots = slots;
        this.reservedSlots = reservedSlots;
        this.weblink = weblink;
        this.sponsor = sponsor;
    }
}