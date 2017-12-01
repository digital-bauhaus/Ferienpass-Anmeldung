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
public class Limitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long limitation_id;

    private String name;

    public Limitation(long limitation_id, String name) {
        this.limitation_id = limitation_id;
        this.name = name;
    }
}