package io.github.pedrosusername.customers.rest;

import io.github.pedrosusername.customers.model.Customer;
import io.github.pedrosusername.customers.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
