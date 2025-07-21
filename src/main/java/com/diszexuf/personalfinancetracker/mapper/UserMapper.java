package com.diszexuf.personalfinancetracker.mapper;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponseDto;
import com.diszexuf.personalfinancetracker.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User mapToEntity(RegistrationRequestDto dto);

    User mapToEntity(AuthRequestDto dto);

    @Mapping(target = "userId", source = "id")
    RegistrationResponseDto mapToDto(User entity);

}
