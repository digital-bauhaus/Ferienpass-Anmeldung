package de.jonashackt.ferienpassanmeldung.domain;

import javax.persistence.*;



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
