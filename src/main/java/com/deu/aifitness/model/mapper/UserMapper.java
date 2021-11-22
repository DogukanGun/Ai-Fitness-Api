package com.deu.aifitness.model.mapper;


import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.model.request.user.CreateUserRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto convertToUserDto(User user);

    User createUser(CreateUserRequest createUserRequest);

    void updateUser(@MappingTarget User user, UpdateUserRequest updateUserRequest);
}
