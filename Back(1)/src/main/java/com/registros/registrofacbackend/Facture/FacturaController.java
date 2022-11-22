package com.registros.registrofacbackend.Facture;

import com.registros.registrofacbackend.Client.Cliente;
import com.registros.registrofacbackend.Client.ClienteRepository;
import com.registros.registrofacbackend.Product.Producto;
import com.registros.registrofacbackend.Product.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Facture")
@RestController
public class FacturaController {

    @Autowired
    private ServicioFactura servicio;
    @GetMapping("/all")
    public List<Factura> getFacturas(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Factura> getFactura(@PathVariable("id") int facturaId) {
        return servicio.getFactura(facturaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura save(@RequestBody Factura factura) {
        return servicio.save(factura);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura update(@RequestBody Factura factura) {
        return servicio.update(factura);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int facturaId) {
        return servicio.deleteFactura(facturaId);
    }




}
