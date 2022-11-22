package com.registros.registrofacbackend.Product;

import com.registros.registrofacbackend.Details.Detalle;
import com.registros.registrofacbackend.Facture.Factura;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @Column(length = 128,nullable = false)
    private String nombre;
    @Column(length = 45,nullable = false)
    private float precio;
    @Column(length = 45,nullable = false)
    private double stock;
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private List<Detalle> detalles = new ArrayList<>();

    public Producto() {

    }
    public void setDetalle(Integer id,String cantidad,String precio){
        this.detalles.add(new Detalle(id,cantidad,precio,this));
    }
    public void añadirDetalles(String cantidad ,String precio){
        this.detalles.add(new Detalle(cantidad,precio,this));
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Producto(int id_producto, String nombre, float precio, double stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
