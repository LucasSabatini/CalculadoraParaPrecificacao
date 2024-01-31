package br.com.sabatini.service;

import br.com.sabatini.controller.UserController;
import br.com.sabatini.exception.IdNotFoundException;
import br.com.sabatini.exception.UserNotFoundException;
import br.com.sabatini.model.dto.UserRequestDTO;
import br.com.sabatini.model.dto.UserResponseDTO;
import br.com.sabatini.model.entity.User;
import br.com.sabatini.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        users.forEach(u -> u.add(linkTo(methodOn(UserController.class).getUserById(u.getId())).withSelfRel()));

        return users;
    }

    public UserResponseDTO getUserById(Long id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID não encontrado!")));

        userResponseDTO.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());

        return userResponseDTO;
    }

    public UserResponseDTO getUserByEmail(String email) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(userRepository.getUserByEmail(email)
                        .orElseThrow(() -> new UserNotFoundException(email)));

        userResponseDTO.add(linkTo(methodOn(UserController.class).getUserById(userResponseDTO.getId())).withSelfRel());

        return userResponseDTO;
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID não encontrado!"));
        userToUpdate.setEmail(userRequestDTO.email());
        userToUpdate.setPassword(passwordEncoder.encode(userRequestDTO.password()));
        userRepository.save(userToUpdate);

        UserResponseDTO userResponseDTO = new UserResponseDTO(userToUpdate);
        userResponseDTO.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());

        return userResponseDTO;
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID não encontrado!"));
        userRepository.deleteById(id);
    }
}
