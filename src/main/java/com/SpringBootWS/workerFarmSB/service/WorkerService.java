package com.SpringBootWS.workerFarmSB.service;

import com.SpringBootWS.workerFarmSB.controller.model.WorkerViewModel;
import com.SpringBootWS.workerFarmSB.controller.model.WorkingHoursViewModel;
import com.SpringBootWS.workerFarmSB.persistency.entity.WorkerEntity;

import java.util.List;

public interface WorkerService {
    WorkerEntity createWorker(WorkerViewModel workerViewModel) throws Exception;

    WorkerEntity findWorker(Long id);

    WorkerEntity addWorkingHours (Long id, int weekNumber);

  //  WorkerEntity findByType(String type);

    List<WorkerEntity> getListOfWorkers();

    void deleteWorker(Long id);
}
