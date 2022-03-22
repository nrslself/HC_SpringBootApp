package com.SpringBootWS.workerFarmSB.service;

import com.SpringBootWS.workerFarmSB.controller.model.WorkerViewModel;
import com.SpringBootWS.workerFarmSB.persistency.entity.WorkerEntity;
import com.SpringBootWS.workerFarmSB.persistency.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultWorkerService implements WorkerService{

    private final WorkerRepository workerRepository;

    public DefaultWorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public WorkerEntity createWorker(WorkerViewModel workerViewModel) throws Exception {

        return this.workerRepository.save(
            new WorkerEntity(
                workerViewModel.getFirstName(),
                workerViewModel.getLastName(),
                workerViewModel.getType()));
    }

    @Override
    public void deleteWorker(Long id) {
        boolean doesExists = this.workerRepository.existsById(id);
        if(!doesExists){
            throw new IllegalStateException(
                    "this " + id + " worker does not exist!"
            );
        }
        this.workerRepository.deleteById(id);
    }

    @Override
    public WorkerEntity findWorker(Long id) {
        return this.workerRepository.findById(id).get();
    }

    @Override
    public WorkerEntity addWorkingHours(Long id, int weekNumber) {

        boolean doesExists = this.workerRepository.existsById(id);
        if(!doesExists){
            throw new IllegalStateException(
                    "this " + id + " worker does not exist!"
            );
        }
        WorkerEntity workerEntity = workerRepository.findById(id).get();
        if(weekNumber>0){
           workerEntity.setWeekNumber(weekNumber);
        }
        return workerEntity;
    }

    @Override
    public List<WorkerEntity> getListOfWorkers() {
        return (List<WorkerEntity>) this.workerRepository.findAll();
    }

}
