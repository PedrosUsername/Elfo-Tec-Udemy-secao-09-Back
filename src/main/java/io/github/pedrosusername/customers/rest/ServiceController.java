package io.github.pedrosusername.customers.rest;

import io.github.pedrosusername.customers.model.Customer;
import io.github.pedrosusername.customers.model.CustomerRepository;
import io.github.pedrosusername.customers.model.Service;
import io.github.pedrosusername.customers.model.ServiceRepository;
import io.github.pedrosusername.customers.rest.dto.ServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServiceController {
    private final CustomerRepository customerRepository;
    private final ServiceRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Service salvar(@RequestBody ServiceDTO dto ){
        LocalDate data = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getClientId();

        Customer customer =
                customerRepository
                        .findById(idCliente)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Cliente inexistente."));


        Service servicoPrestado = new Service();
        servicoPrestado.setDescription(dto.getDescription());
        servicoPrestado.setDate( data );
        servicoPrestado.setCustomer(customer);
        servicoPrestado.setValue( dto.getPrice() );

        return repository.save(servicoPrestado);
    }


    @GetMapping
    public List<Service> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }

}
