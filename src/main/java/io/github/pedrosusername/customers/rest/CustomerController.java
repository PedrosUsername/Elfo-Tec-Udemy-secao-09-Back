package io.github.pedrosusername.customers.rest;

import io.github.pedrosusername.customers.model.Customer;
import io.github.pedrosusername.customers.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/clientes")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer salvar( @RequestBody Customer customer ){
        return repository.save(customer);
    }

    @GetMapping("{id}")
    public Customer acharPorId( @PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }
}
