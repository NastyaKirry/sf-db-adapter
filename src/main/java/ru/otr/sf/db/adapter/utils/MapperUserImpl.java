package ru.otr.sf.db.adapter.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otr.sf.db.adapter.dto.EmailDto;
import ru.otr.sf.db.adapter.dto.UserDto;
import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
class MapperUserImpl implements MapperUser {

    public UserDto userToDto(User user) {
        List<Email> emails = user.getEmails();
        List<EmailDto> emailsD = new ArrayList<>();
        for (Email email:emails) {
            EmailDto emailD = new EmailDto();
            emailD.setId(email.getId());
            emailD.setEmail(email.getEmail());
            emailsD.add(emailD);
        }
        return new UserDto(user.getId(),user.getUsername(), emailsD);
    }

    public User DtoToUser(UserDto userDTO) {
        List<EmailDto> emailsD = userDTO.getEmails();
        List<Email> emails = new ArrayList<>();
        for (EmailDto emailD:emailsD) {
            Email email = new Email();
            email.setId(emailD.getId());
            email.setEmail(emailD.getEmail());
            emails.add(email);
        }
        return new User(userDTO.getName(), emails);
    }
}
