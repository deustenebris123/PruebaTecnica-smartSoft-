package com.registros.registrofacbackend.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioFactura {
    @Autowired
    private FacturaCrudRepository metodosCrud;

    public List<Factura> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Factura> getFactura(int FacturaId) {return metodosCrud.getFactura(FacturaId);
    }

    public Factura save(Factura factura) {
        if (factura.getNum_factura()== null) {
            return metodosCrud.save(factura);
        } else {
            Optional<Factura> factura1 = metodosCrud.getFactura(factura.getNum_factura());
            if (factura1.isPresent()) {
                return metodosCrud.save(factura);
            } else {
                return factura;
            }
        }
    }


    public Factura update( Factura factura){
        if(factura.getNum_factura()!=0){
            Optional< Factura>g=metodosCrud.getFactura(factura.getNum_factura());
            if(!g.isEmpty()){
                if(factura.getFecha()!=null){
                    g.get().setFecha(factura.getFecha());
                }
                return metodosCrud.save(g.get());
            }
        }
        return factura;
    }
    public boolean deleteFactura(int facturaId){
        Boolean d=getFactura(facturaId).map(factura -> {
            metodosCrud.delete(factura);
            return true;
        }).orElse(false);
        return d;
    }

}
