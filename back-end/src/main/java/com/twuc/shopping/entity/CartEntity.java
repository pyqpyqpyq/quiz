package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(generator = "CartIdGenerator")
    @GenericGenerator(name = "CartIdGenerator", strategy = "com.twuc.shopping.entity.generator.CartIdGenerator")
    private String id;


//    @OneToMany(cascade = CascadeType.ALL)
//    private List<ProductEntity> products;
}
