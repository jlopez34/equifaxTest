package com.equifax.trial.backend.model.dao;

import com.equifax.trial.backend.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerDao extends JpaRepository<Worker, Long> {

    List<Worker> findAll();
    Worker findByNameAndDni(String name, String dni);
}
