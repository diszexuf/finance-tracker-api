package com.diszexuf.personalfinancetracker.mapper;

import com.diszexuf.personalfinancetracker.dto.transaction.TransactionRequestDto;
import com.diszexuf.personalfinancetracker.dto.transaction.TransactionResponseDto;
import com.diszexuf.personalfinancetracker.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "category.id", source = "categoryId")
    Transaction mapToEntity(TransactionRequestDto dto);

    @Mapping(target = "categoryId", source = "category.id")
    TransactionResponseDto mapToDto(Transaction entity);

    @Mapping(target = "categoryId", source = "category.id")
    List<TransactionResponseDto> mapToDtos(List<Transaction> entity);

    @Mapping(target = "categoryId", source = "category.id")
    void updateTransactionFromDto(TransactionRequestDto dto, @MappingTarget Transaction transaction);

}
