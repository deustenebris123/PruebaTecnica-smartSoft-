package com.registros.registrofacbackend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin
//indicamos que es un controlador mediante el @RestCtroller
@RestController
@RequestMapping("/products")
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ProductoController {
    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping("/all")
    public List<Producto> getClients() {
        return servicioProducto.getAll();
    }

    @GetMapping("all/{id}")
    public Optional<Producto> getClient(@PathVariable("id") int productoId) {
        return servicioProducto.getProducto(productoId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {
        return servicioProducto.save(producto);
    }

   @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto) {
        return servicioProducto.update(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int productoId) {
        return servicioProducto.deleteProducto(productoId);
    }
}

