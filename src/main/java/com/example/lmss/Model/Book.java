package com.example.lmss.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    @NotNull(message = "id is required")
    private int id;

    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "number of pages is required")
    private int num_pages;

    @NotNull(message = "price is required")

    private double price;
    @NotNull(message = "price is required")

    @Pattern(regexp = "novel|academic", message = " category must be novel OR academic")
    private String category;

    @NotEmpty(message = "isAvailble is required")
    private boolean isAvailble;
}
