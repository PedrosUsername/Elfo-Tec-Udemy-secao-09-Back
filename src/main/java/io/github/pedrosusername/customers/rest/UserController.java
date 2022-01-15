package io.github.pedrosusername.customers.rest;

import io.github.pedrosusername.customers.UserService;
import io.github.pedrosusername.customers.UsuarioCadastradoException;
import io.github.pedrosusername.customers.model.User;
import io.github.pedrosusername.customers.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid User usuario){
        try{
            service.save(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }
    }
}
