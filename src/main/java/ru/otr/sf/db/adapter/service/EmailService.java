package ru.otr.sf.db.adapter.service;

import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;

import java.util.List;
import java.util.Optional;

public interface EmailService {

    Optional<Email> getById(Long Id);

    List<Email> getFindAll();

    Email addEmail(String username, Long userId);
}
