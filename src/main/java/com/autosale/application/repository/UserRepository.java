package com.autosale.application.repository;

import com.autosale.application.model.domain.User;
import com.autosale.application.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndStatusNot(String email, Status status);
    boolean existsByEmailAndStatusNot(String email, Status status);
    List<User> findAllByStatusNot(Status s);
    Optional<User> findByIdAndStatusNot(Long id, Status status);
}
