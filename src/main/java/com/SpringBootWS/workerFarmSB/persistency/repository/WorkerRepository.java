package com.SpringBootWS.workerFarmSB.persistency.repository;

import com.SpringBootWS.workerFarmSB.persistency.entity.WorkerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<WorkerEntity, Long> {

    List<WorkerEntity> findByType(String type);

    WorkerEntity findById(long id);


}
