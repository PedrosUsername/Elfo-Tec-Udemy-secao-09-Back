package io.github.pedrosusername.customers.model;

import com.sun.istack.NotNull;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "usuario")
    @NotEmpty(message = "nome de usuario vazio")
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "insira uma senha")
    private String password;

}
