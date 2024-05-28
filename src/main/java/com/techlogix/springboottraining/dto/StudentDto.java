package com.techlogix.springboottraining.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {

    @NotBlank(message = "name shouldn't be null / empty")
    private String name;

    @NotBlank(message = "email shouldn't be null / empty")
    @Email(message = "invalid email address")
    private String email;

    @NotNull(message = "age is missing")
    @Min(18)
    @Max(100)
    private Integer age;

    @NotNull(message = "department id is missing")
    private Integer departmentId;
}
