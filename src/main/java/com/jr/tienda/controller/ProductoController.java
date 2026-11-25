package com.jr.tienda.controller;

import com.jr.tienda.model.Producto;
import com.jr.tienda.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private ProductoService productoService;

    public ProductoController (ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> verTodos(){
        return productoService.traerTodos();
    }

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Producto> traerUno(@PathVariable int id){
        return productoService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody  Producto producto){
        Producto nuevoProducto = productoService.guardar(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }





}
