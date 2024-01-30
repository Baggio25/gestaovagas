package com.baggio.gestaovagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "job")
@Data
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(columnDefinition = "TEXT")
  @NotBlank(message = "O campo [description] é obrigatório")
  private String description;

  @NotBlank(message = "O campo [benefits] é obrigatório")
  private String benefits;

  @NotBlank(message = "O campo [level] é obrigatório")
  private String level;

  @ManyToOne
  @JoinColumn(name="company_id", insertable = false, updatable = false)
  private CompanyEntity company;

  @Column(name = "created_at") 
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }

}
