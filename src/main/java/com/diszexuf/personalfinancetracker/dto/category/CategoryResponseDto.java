package com.diszexuf.personalfinancetracker.dto.category;

import com.diszexuf.personalfinancetracker.model.CategoryType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoryResponseDto {
    @NotNull(message = "ID must not be null")
    private UUID id;

    @NotNull(message = "Name must not be null")
    private String name;

    @NotNull(message = "Type must not be null")
    private CategoryType type;
}
