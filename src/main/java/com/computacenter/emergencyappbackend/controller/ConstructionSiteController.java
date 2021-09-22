package com.computacenter.emergencyappbackend.controller;

import com.computacenter.emergencyappbackend.dtos.ConstructionSiteDto;
import com.computacenter.emergencyappbackend.models.ConstructionSite;
import com.computacenter.emergencyappbackend.services.ConstructionSiteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/constructionSite")
public class ConstructionSiteController {

    @Autowired
    ConstructionSiteService constructionSiteService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ConstructionSiteDto> addConstructionSite(@RequestBody ConstructionSiteDto constructionSiteDto) {
        ConstructionSite constructionSite = modelMapper.map(constructionSiteDto, ConstructionSite.class);
        constructionSiteService.addConstructionSite(constructionSite);
        ConstructionSiteDto constructionSiteResponse = modelMapper.map(constructionSite, ConstructionSiteDto.class);
        return new ResponseEntity<>(constructionSiteResponse, HttpStatus.OK);
    }

    @GetMapping
    public List<ConstructionSiteDto> getAll() {
        return constructionSiteService.getAll().stream().map(constructionSite -> modelMapper.map(constructionSite, ConstructionSiteDto.class))
                .collect(Collectors.toList());
    }
}
