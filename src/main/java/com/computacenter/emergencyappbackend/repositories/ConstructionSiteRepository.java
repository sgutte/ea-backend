package com.computacenter.emergencyappbackend.repositories;

import com.computacenter.emergencyappbackend.models.ConstructionSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionSiteRepository extends JpaRepository<ConstructionSite, Long> {
}
