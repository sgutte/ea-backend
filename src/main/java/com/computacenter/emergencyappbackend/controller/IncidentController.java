package com.computacenter.emergencyappbackend.controller;

import com.computacenter.emergencyappbackend.dtos.IncidentDto;
import com.computacenter.emergencyappbackend.models.Incident;
import com.computacenter.emergencyappbackend.services.IncidentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incident")
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<IncidentDto> addIncident(@RequestBody IncidentDto incidentDto) {
        Incident incident = modelMapper.map(incidentDto, Incident.class);
        incidentService.addIncident(incident);
        IncidentDto incidentResponse = modelMapper.map(incident, IncidentDto.class);
        return new ResponseEntity<>(incidentResponse, HttpStatus.OK);
    }

    @GetMapping
    public List<IncidentDto> getAll() {
        return incidentService.getAll().stream().map(incident -> modelMapper.map(incident, IncidentDto.class))
                .collect(Collectors.toList());
    }

}
