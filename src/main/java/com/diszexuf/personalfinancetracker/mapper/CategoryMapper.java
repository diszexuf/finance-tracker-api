package com.diszexuf.personalfinancetracker.mapper;

import com.diszexuf.personalfinancetracker.dto.category.CategoryRequestDto;
import com.diszexuf.personalfinancetracker.dto.category.CategoryResponseDto;
import com.diszexuf.personalfinancetracker.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category mapToEntity(CategoryRequestDto dto);

    CategoryResponseDto mapToDto(Category entity);

    void updateCategoryFromDto(CategoryRequestDto dto, @MappingTarget Category category);

    List<CategoryResponseDto> mapToDtos(List<Category> entities);
}
