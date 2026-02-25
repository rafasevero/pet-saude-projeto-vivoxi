package com.petSaudeUnicentro.projetoVivoxi.service;

import com.petSaudeUnicentro.projetoVivoxi.domain.user.*;
import com.petSaudeUnicentro.projetoVivoxi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserRequestDTO data){

        User newUser = new User();
        newUser.setName(data.name());
        newUser.setLogin(data.login());
        newUser.setEmail(data.email());
        newUser.setPassword(data.password());

        userRepository.save(newUser);
        return newUser;
    }

    public List<UserResponseDTO> getAllUsers(){
        List<User> allUsers = this.userRepository.findAll();
        return allUsers.stream()
                .map(user -> new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getEmail()
                ))
                .toList();
    }

    @Transactional //garante que o update seja salvo no banco
    public UserResponseDTO updateUser(UUID id, UserUpdateDTO data){
        User user = userRepository.findById(id) //verifica se existe o usuario no repository
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if(data.name() != null) user.setName(data.name());
        if(data.email() != null) user.setEmail(data.email());
        if(data.login() != null) user.setLogin(data.login());

        userRepository.save(user);
        return new UserResponseDTO(user);
     }

    @Transactional
    public void deleteUser(UUID id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        userRepository.delete(user);
    }

    public UserResponseDTO login(UserLoginRequestDTO data){

        String identifier = data.identifier(); // data.login pode conter o login ou o email

        User user = userRepository.findByLoginOrEmail(identifier, identifier)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login e ou senha incorreta"));

        if(!user.getPassword().equals(data.password())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login e ou senha incorreta");
        }

        return new UserResponseDTO(user);
    }
}
