package com.autosale.application.service.impl;

import com.autosale.application.model.domain.User;
import com.autosale.application.model.enums.Status;
import com.autosale.application.repository.UserRepository;
import com.autosale.application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByStatusNot(Status.DELETED);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findByIdAndStatusNot(id, Status.DELETED)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with id %d not found", id)));
    }

    @Override
    public User createUser(User user) {
        checkIfUserAlreadyExist(user.getEmail());

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {

        User userFromRepo = userRepository.findByIdAndStatusNot(userId, Status.DELETED)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with id %d not found", userId)));

        user.setCreated(userFromRepo.getCreated());
        user.setUpdated(userFromRepo.getUpdated());
        user.setStatus(userFromRepo.getStatus());
        user.setId(userId);

        modelMapper.map(user, userFromRepo);

        return userFromRepo;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findByIdAndStatusNot(userId, Status.DELETED)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with id %d not found", userId)));

        user.setStatus(Status.DELETED);
    }

    private void checkIfUserAlreadyExist(String email) {
        if (userRepository.existsByEmailAndStatusNot(email, Status.DELETED)){
            throw new EntityExistsException(String.format("User with email %s already exist", email));
        }
    }
}
