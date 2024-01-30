package com.baggio.gestaovagas.modules.candidate.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baggio.gestaovagas.exceptions.UserFoundException;
import com.baggio.gestaovagas.modules.candidate.CandidateEntity;
import com.baggio.gestaovagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {

    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException("Username ou email já existentes!");
        });

    return this.candidateRepository.save(candidateEntity);
  }

}
