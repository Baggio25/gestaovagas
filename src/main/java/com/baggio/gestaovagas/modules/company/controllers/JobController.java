package com.baggio.gestaovagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baggio.gestaovagas.modules.company.entities.JobEntity;
import com.baggio.gestaovagas.modules.company.useCase.CreateJobUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
    try {
      var result = this.createJobUseCase.execute(jobEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
