package com.equifax.trial.backend.service;

import com.equifax.trial.backend.response.WorkerRest;
import org.springframework.http.ResponseEntity;

public interface WorkerService {
    public ResponseEntity<WorkerRest> findAll();

    public ResponseEntity<WorkerRest> findByNameAndDni(String name, String dni);

}
