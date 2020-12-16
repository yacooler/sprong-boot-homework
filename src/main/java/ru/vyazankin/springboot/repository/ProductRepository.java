package ru.vyazankin.springboot.repository;

import org.springframework.stereotype.Component;
import ru.vyazankin.springboot.entity.Product;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository {
    public List<Product> getProducts();
    public Optional<Product> findProductByID(int id);
    public void addOrUpdateProduct(Product product);
    public void deleteProduct(Product product);
    public void deleteProductByID(int ID);
}
