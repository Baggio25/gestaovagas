package com.baggio.gestaovagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O campo [name] é obrigatório")
  private String name;

  @NotBlank(message = "O campo [username] é obrigatório")
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
  private String username;

  @NotBlank(message = "O campo [email] é obrigatório")
  @Email(message = "O campo [email] está inválido")
  private String email;

  @Length(min = 10, max = 100, message = "o campo [password] deve conter de 10 a 100 caracteres")
  private String password;
  private String website;

  @Column(columnDefinition = "TEXT")
  private String description;

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
