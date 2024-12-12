package com.example.semana6.controller;

import com.example.semana6.model.Producto;
import com.example.semana6.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService productoService) {
        this.service = productoService;
    }

    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("productos", this.service.listarTodas());
        return "productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());
        return "form";
    }

    @PostMapping
    public String guardarPersona(@ModelAttribute Producto producto) {
        this.service.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", this.service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID invalido" + id)));
        return "form";
    }
}
