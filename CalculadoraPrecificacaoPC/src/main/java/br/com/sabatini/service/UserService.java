package br.com.sabatini.service;

import br.com.sabatini.exception.IdNotFoundException;
import br.com.sabatini.exception.UserNotFoundException;
import br.com.sabatini.model.dto.UserResponseDTO;
import br.com.sabatini.model.entity.User;
import br.com.sabatini.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponseDTO::new).toList();
    }

    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id).map(UserResponseDTO::new).orElseThrow(() -> new IdNotFoundException("ID não encontrado!"));
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Transactional
    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID não encontrado!"));
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID não encontrado!"));
        userRepository.deleteById(id);
    }
}
