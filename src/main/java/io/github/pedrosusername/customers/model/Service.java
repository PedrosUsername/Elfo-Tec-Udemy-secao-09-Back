package io.github.pedrosusername.customers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Column
    private BigDecimal value;
}
