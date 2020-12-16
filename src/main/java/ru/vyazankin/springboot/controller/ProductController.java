package ru.vyazankin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vyazankin.springboot.entity.Product;
import ru.vyazankin.springboot.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("products", productService.getProducts());
        return "all";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        model.addAttribute("products", productService.getProducts());
        return "edit";
    }


    @GetMapping("/remove/{id}")
    public String remove(Model model, @PathVariable Integer id){
        productService.deleteProductByID(id);
        return "redirect:/edit";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product){
        productService.addOrUpdateProduct(product);
        return "redirect:/edit";
    }

    @GetMapping("/editproduct/{id}")
    public String editProduct(Model model, @PathVariable Integer id){
        model.addAttribute("product", productService.getProductByID(id));
        return "editproduct";
    }

    @PostMapping("/updateproduct")
    public String editProduct(@ModelAttribute Product product){
        productService.addOrUpdateProduct(product);
        return "redirect:/edit";
    }

}
