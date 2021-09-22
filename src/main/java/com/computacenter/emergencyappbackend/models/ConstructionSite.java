package com.computacenter.emergencyappbackend.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "constructionsites")
public class ConstructionSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long constructionId;

    public String city;

    public String street;

    public int houseNumber;

    public Long zipCode;

    @OneToMany(mappedBy = "constructionSite", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Incident> incidents;
}
