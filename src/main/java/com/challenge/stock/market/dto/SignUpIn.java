package com.challenge.stock.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpIn {
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "lastName cannot be null")
    @NotEmpty(message = "lastName cannot be empty")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
}
