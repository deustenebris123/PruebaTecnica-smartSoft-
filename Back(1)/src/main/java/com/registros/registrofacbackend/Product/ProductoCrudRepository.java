package com.registros.registrofacbackend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoCrudRepository {
    @Autowired
    private ProductoRepository crud3;
    public List<Producto> getAll(){
        return (List<Producto>) crud3.findAll();
    }
    public Optional<Producto> getProducto(int id){
        return crud3.findById(id);
    }
    public Producto save(Producto producto){
        return crud3.save(producto);
    }
    public void delete(Producto product){
        crud3.delete(product);
    }



}
