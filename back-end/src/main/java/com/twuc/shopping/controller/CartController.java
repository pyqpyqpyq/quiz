package com.twuc.shopping.controller;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.twuc.shopping.dto.CartDTO;
import com.twuc.shopping.dto.CreateOrderRequestDTO;
import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.CreateOrderRequestEntity;
import com.twuc.shopping.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private static final Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cart")
    public void addCart(@RequestBody CartDTO cartDTO){
        CartEntity tempCartEntity = MAPPER.map(cartDTO, CartEntity.class);
        cartService.addToCart(tempCartEntity);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/carts")
    public void createOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO){
        CreateOrderRequestEntity tempOrderEntity = MAPPER.map(createOrderRequestDTO, CreateOrderRequestEntity.class);
        cartService.creatOrder(tempOrderEntity);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/carts")
    public List<CreateOrderRequestDTO> showCreatedOrders(){
        List<CreateOrderRequestEntity> createOrderRequestDTOS =cartService.listCreateOrderRequest();
        return MAPPER.map(createOrderRequestDTOS,List.class);
    }

    @GetMapping("/cart")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> listAllCart(){
        List<CartEntity> cartEntities =cartService.listCart();
        return MAPPER.map(cartEntities,List.class);
    }

    @DeleteMapping("/cart/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable String name){
       cartService.removeCart(name);
    }
}
