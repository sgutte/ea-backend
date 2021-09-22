package com.computacenter.emergencyappbackend.controller;

import com.computacenter.emergencyappbackend.dtos.WorkerDto;
import com.computacenter.emergencyappbackend.models.Worker;
import com.computacenter.emergencyappbackend.services.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<WorkerDto> addWorker(@RequestBody WorkerDto workerDto){
        Worker worker = modelMapper.map(workerDto, Worker.class);
        workerService.addWorker(worker);
        WorkerDto workerResponse = modelMapper.map(worker, WorkerDto.class);
        return new ResponseEntity<>(workerResponse, HttpStatus.OK);
    }

    @GetMapping
    public List<WorkerDto> getAll(){
        return workerService.getAll().stream().map(worker -> modelMapper.map(worker, WorkerDto.class))
                .collect(Collectors.toList());
    }
}
