package com.computacenter.emergencyappbackend.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long workerId;

    public String firstName;

    public String lastName;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Incident> incidents;
}
