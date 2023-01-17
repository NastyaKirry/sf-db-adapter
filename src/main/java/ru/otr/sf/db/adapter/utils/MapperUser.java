package ru.otr.sf.db.adapter.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.otr.sf.db.adapter.dto.EmailDto;
import ru.otr.sf.db.adapter.dto.UserDto;
import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MapperUser {

     @Mapping(target = "name", source = "username")
     UserDto userToDto(User user);

     @Mapping(target = "username", source = "name")
     @Mapping(target = "id", ignore = true)
     User dtoToUser(UserDto userDTO);

     EmailDto emailToDto (Email email);

     @Mapping(target = "id", ignore = true)
     Email dtoToEmail (Exception emailDTO);

}
