package com.vasilisa.cinema.service.mapper;

import com.vasilisa.cinema.controller.dto.UserDto;
import com.vasilisa.cinema.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> mapUserDtos(List<User> users);

    UserDto mapUserDto(User user);

    User mapUser(UserDto userDto);
}
