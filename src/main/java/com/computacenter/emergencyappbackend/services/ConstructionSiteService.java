package com.computacenter.emergencyappbackend.services;

import com.computacenter.emergencyappbackend.models.ConstructionSite;
import com.computacenter.emergencyappbackend.repositories.ConstructionSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ConstructionSiteService {

    @Autowired
    ConstructionSiteRepository constructionSiteRepository;

    public ConstructionSite addConstructionSite(@RequestBody ConstructionSite constructionSite){
        return constructionSiteRepository.save(constructionSite);
    }

    public List<ConstructionSite> getAll(){
        return constructionSiteRepository.findAll();
    }
}
