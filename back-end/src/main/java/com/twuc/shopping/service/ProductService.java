package com.twuc.shopping.service;

import com.twuc.shopping.dto.ProductDTO;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public ProductEntity AddProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);

    }
}
