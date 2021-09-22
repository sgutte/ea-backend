package com.computacenter.emergencyappbackend.repositories;

import com.computacenter.emergencyappbackend.models.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
