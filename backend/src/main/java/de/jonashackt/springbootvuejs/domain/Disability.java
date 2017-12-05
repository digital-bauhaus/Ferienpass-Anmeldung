package de.jonashackt.springbootvuejs.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Disability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long disability_id;

    private String name;
    private boolean approval;
    private String needsCompanyFor;

    public Disability(long disability_id) {
        this.disability_id = disability_id;
    }

    public Disability(long disability_id, String name, boolean approval, String needsCompanyFor) {
        this.disability_id = disability_id;
        this.name = name;
        this.approval = approval;
        this.needsCompanyFor = needsCompanyFor;
    }

    public long getDisability_id() {
        return disability_id;
    }

    public void setDisability_id(long disability_id) {
        this.disability_id = disability_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public String getNeedsCompanyFor() {
        return needsCompanyFor;
    }

    public void setNeedsCompanyFor(String needsCompanyFor) {
        this.needsCompanyFor = needsCompanyFor;
    }
}