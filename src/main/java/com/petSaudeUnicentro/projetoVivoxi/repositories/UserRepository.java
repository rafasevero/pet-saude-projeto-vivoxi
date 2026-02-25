package com.petSaudeUnicentro.projetoVivoxi.repositories;

import com.petSaudeUnicentro.projetoVivoxi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> { //O JpaRepository transforma métodos Java em comandos SQL automaticamente (ex: findByTitle vira SELECT * FROM...)
    Optional <User> findByLoginOrEmail(String login, String email); // consegue buscar pelo login e email, usando o select
}
