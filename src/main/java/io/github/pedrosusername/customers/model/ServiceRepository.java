package io.github.pedrosusername.customers.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    @Query(" select s from Service s join s.customer c " +
            " where upper( c.name ) like upper( :nome ) and MONTH(s.date) =:mes    ")
    List<Service> findByNomeClienteAndMes(
            @Param("nome") String nome, @Param("mes") Integer mes);
}
