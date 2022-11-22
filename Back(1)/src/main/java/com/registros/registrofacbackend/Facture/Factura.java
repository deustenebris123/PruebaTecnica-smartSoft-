package com.registros.registrofacbackend.Facture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.registros.registrofacbackend.Client.Cliente;
import com.registros.registrofacbackend.Details.Detalle;
import com.registros.registrofacbackend.Product.Producto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="FACTURA")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num_factura;

    @Column(name="fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente",insertable = false,updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("FACTURA")
    private List<Detalle> detalles;





    @Override
    public  String toString(){
        return "fecha";
    }

    public Factura() {
    }

    public Factura(String fecha) {
        this.fecha = fecha;
    }

    public Factura(String fecha, Cliente cliente, List<Detalle> detalles) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = detalles;
    }


    public Integer getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(Integer num_factura) {
        this.num_factura = num_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}
