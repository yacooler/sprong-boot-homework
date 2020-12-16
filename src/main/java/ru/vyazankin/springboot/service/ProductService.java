package ru.vyazankin.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vyazankin.springboot.entity.Product;
import ru.vyazankin.springboot.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.getProducts();
    }

    public Product getProductByID(int id){
        return productRepository.findProductByID(id).orElseThrow(()->new NoSuchElementException());
    }

    public void addOrUpdateProduct(Product product){
        productRepository.addOrUpdateProduct(product);
    }

    public void deleteProduct(Product product){
        productRepository.deleteProduct(product);
    }

    public void deleteProductByID(int ID){
        productRepository.deleteProductByID(ID);
    }


}
