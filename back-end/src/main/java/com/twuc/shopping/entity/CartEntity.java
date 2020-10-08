package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {
    @Id
    private String name;
    private Integer number;
    private Integer price;
    private String unit;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<ProductEntity> products;
}
