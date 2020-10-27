package com.twuc.shopping.dto;

import com.twuc.shopping.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Integer id;
    @NotEmpty(message = "name不能为空")
    private String name;
    @NotNull
    private Integer price;
    @NotEmpty
    private String avatar;
    @NotEmpty
    private String unit;

    public static ProductDTO from(ProductEntity productEntity){
        return ProductDTO.builder()
                .id(productEntity.getId())
                .name((productEntity.getName()))
                .unit(productEntity.getUnit())
                .price(productEntity.getPrice())
                .avatar(productEntity.getAvatar())
                .build();
    }
}
