package ru.vyazankin.springboot.repository;


import org.springframework.stereotype.Component;
import ru.vyazankin.springboot.entity.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductTestRepository implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void initList(){
        products = new ArrayList<>();

        products.add(new Product(1, "Монитор 23'", BigDecimal.valueOf(8700)));
        products.add(new Product(2, "Монитор 34'", BigDecimal.valueOf(28900)));
        products.add(new Product(3, "Материнская плата + Celeron", BigDecimal.valueOf(6800)));
        products.add(new Product(4, "Материнская плата + Ryzen", BigDecimal.valueOf(15400)));
        products.add(new Product(5, "Материнская плата + Xeon с Али", BigDecimal.valueOf(4200)));
        products.add(new Product(6, "Плашка DDR3 8gb", BigDecimal.valueOf(3700)));
        products.add(new Product(7, "Плашка DDR4 8gb", BigDecimal.valueOf(6500)));
        products.add(new Product(8, "Клавиатура и мышь беспроводные, комплект", BigDecimal.valueOf(4300)));
        products.add(new Product(9, "Клавиатура механическая", BigDecimal.valueOf(9200)));
        products.add(new Product(10, "Мышь игровая", BigDecimal.valueOf(17000)));
        products.add(new Product(11, "Корпус с блоком питания 500W", BigDecimal.valueOf(6000)));
        products.add(new Product(12, "Корпус с блоком питания 800W игровой", BigDecimal.valueOf(11000)));
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<Product> findProductByID(int id) {
        for (Product pr: products) {
            if (pr.getId() == id) return Optional.of(pr);
        }
        return Optional.empty();
    }

    @Override
    public void addOrUpdateProduct(Product product) {
        var optionalProduct = findProductByID(product.getId());

        //Не было продукта - добавляем
        if (optionalProduct.isEmpty()) {
            products.add(product);
            return;
        }
        //Ничего не изменилось - выходим
        if (optionalProduct.get().equals(product)) return;

        //Обновляем продукт
        optionalProduct.get().setValueOf(product);
    }

    @Override
    public void deleteProduct(Product product){
        products.remove(product);
    }

    @Override
    public void deleteProductByID(int ID){
        products.removeIf(product -> product.getId() == ID);
    }
}
