package com.example.project.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PlacementFilter")
public class PlacementFilter implements Serializable {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    @Column(name="id")
    private Integer id;
    @Column(name = "specialisation")
    private String specialisation;
    @Column(name = "domain")
    private String domain;

    public PlacementFilter() {
        super();
    }

    public PlacementFilter(String specialisation, String domain) {
        super();
        this.specialisation = specialisation;
        this.domain = domain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
