package com.diszexuf.personalfinancetracker.service.impl;

import com.diszexuf.personalfinancetracker.dto.category.CategoryRequestDto;
import com.diszexuf.personalfinancetracker.dto.category.CategoryResponseDto;
import com.diszexuf.personalfinancetracker.exception.CategoryAlreadyExistsException;
import com.diszexuf.personalfinancetracker.exception.CategoryNotFoundException;
import com.diszexuf.personalfinancetracker.mapper.CategoryMapper;
import com.diszexuf.personalfinancetracker.model.Category;
import com.diszexuf.personalfinancetracker.repository.CategoryRepository;
import com.diszexuf.personalfinancetracker.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryResponseDto createCategory(CategoryRequestDto dto) {
        log.info("Create category use-case");

        if (categoryRepository.existsByName(dto.getName())) {
            throw new CategoryAlreadyExistsException("Category with this name already exists");
        }
        Category category = categoryMapper.mapToEntity(dto);

        log.info("Create category use-case executed successfully");
        return categoryMapper.mapToDto(categoryRepository.save(category));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> getAllCategories() {
        log.info("Get all categories use-case");

        List<CategoryResponseDto> dtos = categoryMapper.mapToDtos(categoryRepository.findAll());

        log.info("Get all categories use-case executed successfully, found {} categories", dtos.size());
        return dtos;
    }

    @Override
    @Transactional
    public CategoryResponseDto updateCategory(UUID id, CategoryRequestDto dto) {
        log.info("Update category use-case");

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("No such category"));
        if (!category.getName().equals(dto.getName()) && categoryRepository.existsByName(dto.getName())) {
            throw new CategoryAlreadyExistsException("Category with this name already exists");
        }
        categoryMapper.updateCategoryFromDto(dto, category);
        categoryRepository.save(category);

        log.info("Update category use-case executed successfully");
        return categoryMapper.mapToDto(category);
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        log.info("Delete category use-case");

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("No such category"));
        categoryRepository.delete(category);

        log.info("Delete category use-case executed successfully");
    }
}
