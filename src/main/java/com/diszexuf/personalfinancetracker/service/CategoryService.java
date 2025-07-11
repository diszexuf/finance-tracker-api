package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.category.CategoryRequestDto;
import com.diszexuf.personalfinancetracker.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryRequestDto createCategory(CategoryRequestDto dto) {

        return null;
    }

    @Override
    public List<CategoryRequestDto> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryRequestDto updateCategory(CategoryRequestDto dto) {
        return null;
    }

    @Override
    public CategoryRequestDto deleteCategory(UUID id) {
        return null;
    }
}
