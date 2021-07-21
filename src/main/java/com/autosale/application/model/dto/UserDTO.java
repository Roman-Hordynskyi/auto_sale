package com.autosale.application.model.dto;

import com.autosale.application.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;

    @Length(min = 1, max = 50)
    @NotBlank
    private String firstName;

    @Length(min = 1, max = 50)
    @NotBlank
    private String lastName;

    @Length(min = 1, max = 100)
    @Email(message = "email cant be empty")
    private String email;

    @Length(min = 1, max = 50)
    @NotEmpty
    private String password;

    @NotNull
    private int age;

    private LocalDateTime created;

    private LocalDateTime updated;

}
