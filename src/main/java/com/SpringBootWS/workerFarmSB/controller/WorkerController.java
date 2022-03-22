package com.SpringBootWS.workerFarmSB.controller;


import com.SpringBootWS.workerFarmSB.controller.model.WorkerViewModel;
import com.SpringBootWS.workerFarmSB.controller.model.WorkingHoursViewModel;
import com.SpringBootWS.workerFarmSB.persistency.entity.WorkerEntity;
import com.SpringBootWS.workerFarmSB.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkerEntity>> getListOfWorkers(){

        List<WorkerEntity> workerEntityList = this.workerService.getListOfWorkers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(workerEntityList);

    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkerEntity> getWorkerById(@PathVariable("id") Long id){

        WorkerEntity existingWorkerEntity = this.workerService.findWorker(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(existingWorkerEntity);
    }

    @PostMapping
    public ResponseEntity createAWorker(@RequestBody WorkerViewModel workerViewModel) throws Exception {

        WorkerEntity newWorkerEntity = this.workerService.createWorker(workerViewModel);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newWorkerEntity);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity addWorkingHours(
            @PathVariable ("id") Long id,
            @RequestParam (required = false) int weekNumber) throws Exception {

        WorkerEntity workerEntity = this.workerService.addWorkingHours(id, weekNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(workerEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersonById(@PathVariable("id") Long id){

        this.workerService.deleteWorker(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
