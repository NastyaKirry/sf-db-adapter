package ru.otr.sf.db.adapter.utils;

import ru.otr.sf.db.adapter.dto.UserDto;
import ru.otr.sf.db.adapter.model.User;

public interface MapperUser {

     UserDto userToDto(User user);

     User DtoToUser(UserDto userDTO);

}
