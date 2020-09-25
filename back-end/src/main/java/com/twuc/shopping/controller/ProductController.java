package com.twuc.shopping.controller;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.twuc.shopping.dto.ProductDTO;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductController {

    private static final Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductEntity productEntity =MAPPER.map(productDTO,ProductEntity.class);
        return MAPPER.map( productService.AddProduct(productEntity),ProductDTO.class);
    }


}
