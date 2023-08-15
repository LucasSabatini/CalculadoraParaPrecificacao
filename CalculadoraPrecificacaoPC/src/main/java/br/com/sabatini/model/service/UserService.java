package br.com.sabatini.model.service;

import br.com.sabatini.exception.IdNotFoundException;
import br.com.sabatini.exception.UserNotFoundException;
import br.com.sabatini.model.entity.User;
import br.com.sabatini.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Transactional
    public User updateUserEmail(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
        userRepository.deleteById(id);
    }
}
