package com.registros.registrofacbackend.Details;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DetalleRepository extends JpaRepository<Detalle,Integer> {
}
