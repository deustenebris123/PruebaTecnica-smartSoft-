package com.registros.registrofacbackend.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FacturaCrudRepository {
    @Autowired
    private FacturaRepository crud;
    public List<Factura> getAll(){
        return (List<Factura>) crud.findAll();
    }
    public Optional<Factura> getFactura(int id){
        return crud.findById(id);
    }
    public Factura save(Factura Factura){
        return crud.save(Factura);
    }
    public void delete(Factura Factura){
        crud.delete(Factura);
    }


}
