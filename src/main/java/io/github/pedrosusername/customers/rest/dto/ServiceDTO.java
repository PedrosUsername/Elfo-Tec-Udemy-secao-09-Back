package io.github.pedrosusername.customers.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ServiceDTO {
    private String description;
    private BigDecimal price;
    private String date;
    private Integer clientId;
}
