package ru.otr.sf.db.adapter.service;

import ru.otr.sf.db.adapter.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getById(Long Id);

    List<User> getFindAll();

    User addUsers(String username);
}
