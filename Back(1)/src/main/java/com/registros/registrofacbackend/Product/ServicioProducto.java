package com.registros.registrofacbackend.Product;

import com.registros.registrofacbackend.Facture.Factura;
import com.registros.registrofacbackend.Facture.FacturaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ServicioProducto {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductoCrudRepository metodosCrud;

    public List<Producto> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Producto> getProducto(int ProductoId) {return metodosCrud.getProducto(ProductoId);
    }

    public Producto save(Producto producto) {
        if (producto.getId_producto()== 0) {
            return metodosCrud.save(producto);
        } else {
            Optional<Producto> producto1 = metodosCrud.getProducto(producto.getId_producto());
            if (producto1.isPresent()) {
                return metodosCrud.save(producto);
            } else {
                return producto;
            }
        }
    }
    public Producto update( Producto producto){
        if(producto.getId_producto()!=0){
            Optional<Producto>g=metodosCrud.getProducto(producto.getId_producto());
            if(!g.isEmpty()){
                if(producto.getNombre()!=null){
                    g.get().setNombre(producto.getNombre());
                }
                if(producto.getPrecio()!=0){
                    g.get().setPrecio(producto.getPrecio());
                }
                if(producto.getStock()!=0){
                    g.get().setStock(producto.getStock());
                }
                return metodosCrud.save(g.get());
            }
        }
        return producto;
    }
    public boolean deleteProducto(int productoId){
        Boolean d=getProducto(productoId).map(producto -> {
            metodosCrud.delete(producto);
            return true;
        }).orElse(false);
        return d;
    }


}
