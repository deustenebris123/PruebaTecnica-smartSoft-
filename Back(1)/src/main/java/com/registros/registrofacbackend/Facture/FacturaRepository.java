package com.registros.registrofacbackend.Facture;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura,Integer> {
}
