package com.petSaudeUnicentro.projetoVivoxi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Table(name = "tb_user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class User {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    public int hashCode() { //hashCode cria um endereco rapido para recuperar automaticamente, caso precise de algum objeto
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        User other = (User) obj;
        return Objects.equals(id, other.id); //equals serve p comparar, ver se é o mesmo obj, independente se estão em lugares diferentes da memoria
    }
}
