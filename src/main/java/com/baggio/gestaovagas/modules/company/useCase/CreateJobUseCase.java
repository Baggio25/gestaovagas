package com.baggio.gestaovagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baggio.gestaovagas.modules.company.entities.JobEntity;
import com.baggio.gestaovagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
  
  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }


}
