package com.jr.tienda.service;

import com.jr.tienda.model.Producto;
import com.jr.tienda.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService( ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    //TRAER TODOS
    public List<Producto> traerTodos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> traerUno(int id){
        return productoRepository.findById(id);
    }

    //GUARDAR
    public Producto  guardar (Producto producto){
        return productoRepository.save(producto);
    }





}
