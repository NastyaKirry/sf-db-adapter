package ru.otr.sf.db.adapter.service.impl;

import org.springframework.stereotype.Service;
import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;
import ru.otr.sf.db.adapter.repository.EmailRepository;
import ru.otr.sf.db.adapter.repository.UserRepository;
import ru.otr.sf.db.adapter.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository, EmailRepository emailRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
    }

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    @Override
    public Optional<User> getById(Long id) {
        Optional<User> users = userRepository.findById(id);
        //users.isPresent()
        return users;
    }

    @Override
    public List<User> getFindAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUsers(User user) {
        for (Email email:user.getEmails()) {
            email.setId(null);
            email.setUser(user);
            emailRepository.save(email);
        }
            userRepository.save(user);
        return user;
    }


    @Override
    public void deleteUsers(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUsers(String username){
        List<User> all = userRepository.findAll();
        List<User> result = new ArrayList<User>();
        for(User user : all){
            boolean contains = user.getUsername().contains(username);
            if(contains){
                result.add(user);
            }
        }
        return result;
    }
}
