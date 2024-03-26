package com.equifax.trial.backend.service;

import com.equifax.trial.backend.model.Worker;
import com.equifax.trial.backend.model.dao.WorkerDao;
import com.equifax.trial.backend.response.WorkerRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkerServiceImplTest {

    @InjectMocks
    WorkerServiceImpl service;

    List<Worker> workerList = new ArrayList<Worker>();

    @Mock
    WorkerDao workerDao;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.loadWorkers();
    }

    @Test
    public void findWorkersTest(){
        when(workerDao.findAll()).thenReturn(workerList);
        ResponseEntity<WorkerRest> response = service.findAll();
        assertEquals(4, response.getBody().getWorkerResponse().getWorkers().size());
        verify(workerDao, times(1)).findAll();
    }

    public void loadWorkers(){
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Worker worker1 = new Worker(Long.valueOf(1),"carlos","1111111-1", true, new Date());
        Worker worker2 = new Worker(Long.valueOf(2),"novac","1111111-1", true,
                Date.from(LocalDate.of(2016, 8, 19).atStartOfDay(defaultZoneId).toInstant()));
        Worker worker3 = new Worker(Long.valueOf(3),"janner","1111111-1", false,
                Date.from(LocalDate.of(2020, 8, 19).atStartOfDay(defaultZoneId).toInstant()));
        Worker worker4 = new Worker(Long.valueOf(4),"danny","1111111-1", true, new Date());

        workerList.add(worker1);
        workerList.add(worker2);
        workerList.add(worker3);
        workerList.add(worker4);

    }
}
