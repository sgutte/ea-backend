package com.computacenter.emergencyappbackend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class IncidentDto {

    public Long incidentId;
    public String injury;
    public String state;
    public String firstAidMeasures;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Berlin")
    public Date date;

    public WorkerDto worker;
    public ConstructionSiteDto constructionSite;
}
