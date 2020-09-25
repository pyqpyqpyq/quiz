package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotEmpty(message = "name不能为空")
    private String name;
    @NotNull
    private Integer price;
    @NotEmpty
    private String avatar;
    @NotEmpty
    private String unit;
}
