package com.twuc.shopping.repository;

import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.CreateOrderRequestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreateOrderRepository extends CrudRepository<CreateOrderRequestEntity, Integer> {
    List<CreateOrderRequestEntity> findAll();
}
