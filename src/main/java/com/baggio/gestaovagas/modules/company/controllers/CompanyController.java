package com.baggio.gestaovagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baggio.gestaovagas.modules.company.entities.CompanyEntity;
import com.baggio.gestaovagas.modules.company.useCase.CreateCompanyUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {

  @Autowired
  private CreateCompanyUseCase companyUseCase;

  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
    try {
      var result = this.companyUseCase.execute(companyEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
