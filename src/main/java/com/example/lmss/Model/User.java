package com.example.lmss.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotNull(message = "id is required")
    private int id;

    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "age is required")
    private int age;


    @NotNull(message = "balance is required")
     private double balance;


    @Pattern(regexp = "customer|librarian", message = " category must be customer OR librarian")
    @NotEmpty(message = "role is required")
     private String role;

}
