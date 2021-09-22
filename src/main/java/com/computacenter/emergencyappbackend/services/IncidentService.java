package com.computacenter.emergencyappbackend.services;

import com.computacenter.emergencyappbackend.models.Incident;
import com.computacenter.emergencyappbackend.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    IncidentRepository incidentRepository;


    public Incident addIncident(Incident incident){
        return incidentRepository.save(incident);
    }

    public Incident get(@PathVariable Long id){ return incidentRepository.findById(id).get();}

    public List<Incident> getAll(){
        return incidentRepository.findAll();
    }
}
