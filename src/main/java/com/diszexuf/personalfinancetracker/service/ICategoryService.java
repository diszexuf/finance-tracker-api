package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.category.CategoryRequestDto;
import com.diszexuf.personalfinancetracker.dto.category.CategoryResponseDto;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto dto);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto updateCategory(UUID id, CategoryRequestDto dto);

    void deleteCategory(UUID id);

}
