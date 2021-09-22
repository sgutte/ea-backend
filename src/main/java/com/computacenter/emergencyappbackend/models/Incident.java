package com.computacenter.emergencyappbackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.TemporalType;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long incidentId;

    public String injury;

    public String state;

    public String firstAidMeasures;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Berlin")
    public Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workerId")
    public Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructionSiteId")
    public ConstructionSite constructionSite;
}
