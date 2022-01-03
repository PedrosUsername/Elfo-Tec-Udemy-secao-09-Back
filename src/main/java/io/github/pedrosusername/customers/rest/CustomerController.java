package io.github.pedrosusername.customers.rest;

import io.github.pedrosusername.customers.model.Customer;
import io.github.pedrosusername.customers.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @GetMapping
    public List<Customer> obterTodos(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Customer acharPorId( @PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id ){
        repository
                .findById(id)
                .map( customer -> {
                    repository.delete(customer);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,
                           @RequestBody Customer customerNew ) {
        repository
                .findById(id)
                .map( customer -> {
                    customerNew.setId(customer.getId());
                    return repository.save(customerNew);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }
}
