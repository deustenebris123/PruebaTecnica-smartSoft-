package com.registros.registrofacbackend.Client;

import com.registros.registrofacbackend.Facture.Factura;
import com.registros.registrofacbackend.Facture.FacturaRepository;
import com.registros.registrofacbackend.Product.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/client")
public class ClienteController {
    @Autowired
    private ServicioCliente servicio;
    @GetMapping("/all")
    public List<Cliente> getCliente(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getCategoria(@PathVariable("id") int categoriaId) {
        return servicio.getCliente(categoriaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cLiente) {
        return servicio.save(cLiente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente) {
        return servicio.update(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clienteId) {
        return servicio.deleteCliente(clienteId);
    }



}
