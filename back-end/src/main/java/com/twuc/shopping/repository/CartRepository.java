package com.twuc.shopping.repository;

import com.twuc.shopping.entity.CartEntity;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {
    Optional<CartEntity> findByName(String name);
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "UPDATE cart_entity SET cart_entity.number = :number WHERE cart_entity.`name` = :name ")
    void updateNumber(@Param("name") String name,@Param("number") Integer number);
}
