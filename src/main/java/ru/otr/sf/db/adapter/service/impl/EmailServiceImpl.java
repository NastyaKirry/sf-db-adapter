package ru.otr.sf.db.adapter.service.impl;

import org.springframework.stereotype.Service;
import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;
import ru.otr.sf.db.adapter.repository.EmailRepository;
import ru.otr.sf.db.adapter.repository.UserRepository;
import ru.otr.sf.db.adapter.service.EmailService;

import java.util.List;
import java.util.Optional;
@Service
public class EmailServiceImpl implements EmailService {

    public EmailServiceImpl(EmailRepository emailRepository, UserRepository userRepository) {
        this.emailRepository = emailRepository;
        this.userRepository = userRepository;
    }

    private final EmailRepository emailRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<Email> getById(Long id) {
        Optional<Email> email = emailRepository.findById(id);
        return email;
    }

    @Override
    public List<Email> getFindAll() {
        return emailRepository.findAll();
    }


    @Override
    public Email addEmail(String email, Long userId) {
        Email emai = new Email();
        Optional<User> user = userRepository.findById(userId);
        emai.setUser(user.get());
        emai.setEmail(email);
        emailRepository.save(emai);
        return emai;
    }
}
