package com.computacenter.emergencyappbackend.services;

import com.computacenter.emergencyappbackend.models.Worker;
import com.computacenter.emergencyappbackend.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public Worker addWorker(@RequestBody Worker worker){
        return workerRepository.save(worker);
    }

    public List<Worker> getAll(){
        return workerRepository.findAll();
    }

    public Worker findById(@PathVariable Long workerId){
        return workerRepository.findById(workerId).get();
    }


}
