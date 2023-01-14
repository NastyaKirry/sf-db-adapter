package ru.otr.sf.db.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    Optional<Email> findById(Long id);

    List<Email> findAll();

    List<Email> findEmailsByUser(User user);




}
