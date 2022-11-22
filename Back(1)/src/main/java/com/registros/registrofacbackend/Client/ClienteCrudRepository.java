package com.registros.registrofacbackend.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteCrudRepository {
    @Autowired
    private ClienteRepository crud;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        return crud.findById(id);
    }

    public Cliente save(Cliente Cliente){
        return crud.save(Cliente);
    }
    public void delete(Cliente Cliente){
        crud.delete(Cliente);
    }

}
