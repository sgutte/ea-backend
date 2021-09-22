package com.computacenter.emergencyappbackend.dtos;

import lombok.Data;

@Data
public class WorkerDto {

    public Long workerId;
    public String firstName;
    public String lastName;
    //public List<IncidentDto> incidences;
}
