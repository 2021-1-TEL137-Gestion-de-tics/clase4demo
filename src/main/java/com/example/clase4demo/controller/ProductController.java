package com.example.clase4demo.controller;

import com.example.clase4demo.entity.Product;
import com.example.clase4demo.repository.CategoryRepository;
import com.example.clase4demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaProductos", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(Model model) {
        model.addAttribute("listaCategorias",categoryRepository.findAll());
        return "product/newFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(Product product, RedirectAttributes attr) {
        if (product.getId() == 0) {
            attr.addFlashAttribute("msg", "Producto creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
        }
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String editarTransportista(Model model,@RequestParam("id") int id) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            model.addAttribute("product", product);
            model.addAttribute("listaCategorias",categoryRepository.findAll());
            return "product/editFrm";
        } else {
            return "redirect:/product";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            productRepository.deleteById(id);
            attr.addFlashAttribute("msg","Producto borrado exitosamente");
        }
        return "redirect:/product";

    }

}
