package com.baggio.gestaovagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
  
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

}
