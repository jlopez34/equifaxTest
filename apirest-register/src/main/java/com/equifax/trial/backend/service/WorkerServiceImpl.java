package com.equifax.trial.backend.service;

import com.equifax.trial.backend.model.Worker;
import com.equifax.trial.backend.model.dao.WorkerDao;
import com.equifax.trial.backend.response.WorkerRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerServiceImpl.class);

    @Autowired
    private WorkerDao worker;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<WorkerRest> findAll() {
        LOGGER.info("Initialization find all workers method");
        WorkerRest workerRest = new WorkerRest();

        try {
            List<Worker> workers = (List<Worker>) worker.findAll();
            if (!workers.isEmpty()) {
                workerRest.getWorkerResponse().setWorkers(workers);
                workerRest.setMetadata("Response OK", "200", "Success Response");
            } else {
                workerRest.setMetadata("Response OK", "404", "Not Found workers");
                return new ResponseEntity<WorkerRest>(workerRest, HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            workerRest.setMetadata("Response NOK", "500", "Failure Response");
            LOGGER.error("Error getting all workers.", exception.getMessage());
            exception.getStackTrace();
            return new ResponseEntity<>(workerRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(workerRest, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<WorkerRest> findByNameAndDni(String name, String dni) {
        LOGGER.info("Initialization find worker by Name and Dni method");
        WorkerRest workerRest = new WorkerRest();
        List<Worker> workers = new ArrayList<>();

        try {
            Optional<Worker> workerFound = Optional.ofNullable(worker.findByNameAndDni(name, dni));
            if (workerFound.isPresent()) {
                workers.add(workerFound.get());
                workerRest.getWorkerResponse().setWorkers(workers);
                workerRest.setMetadata("Response OK", "200", "Success Response");
            } else {
                workerRest.setMetadata("Response OK", "404", "Not Found Worker by Name " + name + "and Dni" + dni);
                return new ResponseEntity<WorkerRest>(workerRest, HttpStatus.NOT_FOUND);
            }

        } catch (Exception exception) {
            workerRest.setMetadata("Response NOK", "500", "Failure Response");
            LOGGER.error("Error getting worker by parameters.", exception.getMessage());
            exception.getStackTrace();
            return new ResponseEntity<WorkerRest>(workerRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<WorkerRest>(workerRest, HttpStatus.OK);
    }
}
