package com.diszexuf.personalfinancetracker.controller;

import com.diszexuf.personalfinancetracker.dto.category.CategoryRequestDto;
import com.diszexuf.personalfinancetracker.dto.category.CategoryResponseDto;
import com.diszexuf.personalfinancetracker.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CategoryResponseDto createCategory(
            @Valid @RequestBody CategoryRequestDto dto
    ) {
        return categoryService.createCategory(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CategoryResponseDto updateCategory(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody CategoryRequestDto dto
    ) {
        return categoryService.updateCategory(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(
            @PathVariable(value = "id") UUID id
    ) {
        categoryService.deleteCategory(id);
    }

}
