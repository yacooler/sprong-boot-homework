package ru.vyazankin.springboot.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    private int id;
    private String name;
    private BigDecimal cost;


    public void setValueOf(Product product){
        this.setName(product.getName());
        this.setCost(product.getCost());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
            .append(id)
            .append(") наименование='").append(name).append('\'')
            .append(", цена=").append(cost).append(" руб.");

        return sb.toString();
    }


}
