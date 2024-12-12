package com.example.semana6.service;

import com.example.semana6.model.Producto;
import com.example.semana6.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
     @Autowired
     private ProductoRepository repository;
         /**
     * Funcion para listar la tabla producto
     * @return 
     */
    public List<Producto> listarTodas() {
        return repository.findAll();
    }
        /**
     * Funcion para guardar datos de una producto
     * @param producto 
     */
    public void guardar(Producto producto) {
        repository.save(producto);
    }
     /**
     * Funcion para buscar una Producto por id
     * @param id
     * @return 
     */
    public Optional<Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }
        /**
     * Funcion para eliminar el registro de una Producto
     * @param id 
     */
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
