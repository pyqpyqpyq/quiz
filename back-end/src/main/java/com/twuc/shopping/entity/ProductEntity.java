package com.twuc.shopping.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twuc.shopping.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private String avatar;
    private String unit;
    //数据库驼峰
//    @ManyToOne
//    @JoinColumn(name = "")
//    private CartEntity cart;
//
    public ProductEntity from(ProductDTO productDTO){
        return ProductEntity
                .builder()
                .avatar(productDTO.getAvatar())
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .unit(productDTO.getUnit())
                .build();
    }
}


