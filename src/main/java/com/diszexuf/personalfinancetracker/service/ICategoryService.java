package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.category.CategoryRequestDto;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    CategoryRequestDto createCategory(CategoryRequestDto dto);

    List<CategoryRequestDto> getAllCategories();

    CategoryRequestDto updateCategory(CategoryRequestDto dto);

    CategoryRequestDto deleteCategory(UUID id);

}
