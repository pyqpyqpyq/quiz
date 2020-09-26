package com.twuc.shopping.dto;

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
public class CartDTO {
    @NotNull
    private Integer number;
    @NotEmpty
    private String name;
    @NotNull
    private Integer price;
    @NotEmpty
    private String unit;
}
