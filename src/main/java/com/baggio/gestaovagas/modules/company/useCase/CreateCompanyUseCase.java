package com.baggio.gestaovagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baggio.gestaovagas.exceptions.UserFoundException;
import com.baggio.gestaovagas.modules.company.entities.CompanyEntity;
import com.baggio.gestaovagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
  
  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity) {

    this.companyRepository
      .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
      .ifPresent((user) -> {
          throw new UserFoundException("Username ou email já existentes!");
        });

    return this.companyRepository.save(companyEntity);
  }


}
