package com.registros.registrofacbackend.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente {
    @Autowired
    private ClienteCrudRepository metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getCliente(int ClienteId) {
        return metodosCrud.getCliente(ClienteId);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getId_cliente()== 0) {
            return metodosCrud.save(cliente);
        } else {
            Optional<Cliente> categoria1 = metodosCrud.getCliente(cliente.getId_cliente());
            if (categoria1.isPresent()) {
                return metodosCrud.save(cliente);
            } else {
                return cliente;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getId_cliente()!=0){
            Optional<Cliente> e= metodosCrud.getCliente(client.getId_cliente());
            if(!e.isEmpty()){
                if(client.getNombre()!=null){
                    e.get().setNombre(client.getNombre());
                }
                if(client.getFecha_nacimiento()!=null){
                    e.get().setFecha_nacimiento(client.getFecha_nacimiento());
                }
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getTelefono()!=null){
                    e.get().setTelefono(client.getTelefono());
                }
                if(client.getDirección()!=null){
                    e.get().setDirección(client.getDirección());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean deleteCliente(int clienteId){
        Boolean d=getCliente(clienteId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return d;
    }

}
