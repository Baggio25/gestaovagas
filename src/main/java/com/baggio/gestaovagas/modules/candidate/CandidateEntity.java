package com.baggio.gestaovagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "candidate")
public class CandidateEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;

  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
  private String username;

  @Email(message = "O campo [email] está inválido")
  private String email;

  @Length(min = 10, max = 100, message = "o campo [password] deve conter de 10 a 100 caracteres")
  private String password;
  private String description;
  private String curriculum;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  
  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}
