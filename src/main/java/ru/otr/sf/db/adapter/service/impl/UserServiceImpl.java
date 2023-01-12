package ru.otr.sf.db.adapter.service.impl;

import org.springframework.stereotype.Service;
import ru.otr.sf.db.adapter.model.User;
import ru.otr.sf.db.adapter.repository.UserRepository;
import ru.otr.sf.db.adapter.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    public Optional<User> getById(Long id) {
        Optional<User> users = userRepository.findById(id);
        return users;
    }

    @Override
    public List<User> getFindAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUsers(String username) {
        User user = new User();
        user.setUsername(username);
        userRepository.save(user);
        return user;
    }
}
