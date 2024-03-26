package com.equifax.trial.backend.controller;

import com.equifax.trial.backend.response.WorkerRest;
import com.equifax.trial.backend.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class WorkerRestController {

    @Autowired
    private WorkerService service;

    @GetMapping("/workers")
    public ResponseEntity<WorkerRest> searchWorkers() {
        ResponseEntity<WorkerRest> response = service.findAll();
        return response;
    }

    @GetMapping("/worker")
    public ResponseEntity<WorkerRest> searchWorkerByNameAndDni(@RequestParam String name, @RequestParam String dni) {
        ResponseEntity<WorkerRest> response = service.findByNameAndDni(name, dni);
        return response;
    }
}
