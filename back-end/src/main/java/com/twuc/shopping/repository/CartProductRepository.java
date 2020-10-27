package com.twuc.shopping.repository;

import com.twuc.shopping.entity.CartProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProductEntity, Integer> {
    List<CartProductEntity> findAllByCartId(String cartId);
    void deleteAllByCartId(String cartID);
}
