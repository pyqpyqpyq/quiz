package com.twuc.shopping.service;

import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.CreateOrderRequestEntity;
import com.twuc.shopping.repository.CartRepository;
import com.twuc.shopping.repository.CreateOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final static Integer ADD_ONE=1;
    private CartRepository cartRepository;
    private CreateOrderRepository createOrderRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public void addToCart(CartEntity cartEntity){
        Optional<CartEntity> tempCart = cartRepository.findByName(cartEntity.getName());
        if (tempCart.isPresent()){
            cartRepository.updateNumber(cartEntity.getName(),tempCart.get().getNumber()+ADD_ONE);
        }else {
            cartEntity.setNumber(ADD_ONE);
            cartRepository.save(cartEntity);
        }
    }
    public List<CartEntity> listCart(){
        return cartRepository.findAll();
    }

    @Transactional
    public void removeCart(String name){
        cartRepository.deleteByName(name);
    }

    @Transactional
    public void creatOrder(CreateOrderRequestEntity createOrderRequestEntity){
       Optional<CreateOrderRequestEntity> tempRequest =createOrderRepository.findById(createOrderRequestEntity.getId());
       if (tempRequest.isPresent()){
           createOrderRepository.save(createOrderRequestEntity);
       }
       else {
           createOrderRepository.save(createOrderRequestEntity);
       }
    }

    public List<CreateOrderRequestEntity> listCreateOrderRequest(){
        return createOrderRepository.findAll();
    }
}
