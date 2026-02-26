package com.petSaudeUnicentro.projetoVivoxi.domain.user;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String login, String email){

    public UserResponseDTO(User user){
        this(user.getId(),user.getName(),user.getLogin(),user.getEmail());
    }
}
