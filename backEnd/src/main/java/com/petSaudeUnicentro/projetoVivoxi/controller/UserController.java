package com.petSaudeUnicentro.projetoVivoxi.controller;

import com.petSaudeUnicentro.projetoVivoxi.domain.user.*;
import com.petSaudeUnicentro.projetoVivoxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173") // permite que o React (localhost:5173 ou 3000) acesse a API
@RestController
@RequestMapping("/vivoxi/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO data ) {
        User newUser = this.userService.createUser(data);
        return ResponseEntity.ok(new UserResponseDTO(newUser));
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        List<UserResponseDTO> allUsers = this.userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID id, @RequestBody UserUpdateDTO data){
        UserResponseDTO updateUser = userService.updateUser(id, data);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        this.userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserLoginRequestDTO data) {
        UserResponseDTO response = userService.login(data);
        return ResponseEntity.ok(response);
    }


}
