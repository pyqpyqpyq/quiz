package com.twuc.shopping.repository;

import com.twuc.shopping.entity.CartEntity;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<CartEntity, String> {
    List<CartEntity> findAll();
}
