package com.registros.registrofacbackend.Details;

import com.registros.registrofacbackend.Facture.Factura;
import com.registros.registrofacbackend.Product.Producto;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name="DETALLE")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_detalle;

    @Column(name="cantidad")
    private Integer cantidad;

    @Column(name="precio")
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name="id_factura")
    private Factura factura;

    public Detalle(Integer cantidad, Float precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Detalle() {
    }

    public Detalle(int num_detalle, Integer cantidad, Float precio, Producto producto, Factura factura) {
        this.num_detalle = num_detalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.factura = factura;
    }

    public Detalle(String cantidad, String precio, Producto producto) {
    }

    public Detalle(Integer id, String cantidad, String precio, Producto producto) {
    }

    public int getNum_detalle() {
        return num_detalle;
    }

    public void setNum_detalle(int num_detalle) {
        this.num_detalle = num_detalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


    @Override
    public String toString(){//to string para retornar la cantidad el precio del producto
        return cantidad + " - " + precio;
    }
}
