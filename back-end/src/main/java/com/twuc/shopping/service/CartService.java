package com.twuc.shopping.service;

import com.github.dozermapper.core.Mapper;
import com.twuc.shopping.dto.CartDTO;
import com.twuc.shopping.dto.CartProductDTO;
import com.twuc.shopping.dto.ProductDTO;
import com.twuc.shopping.entity.CartEntity;
import com.twuc.shopping.entity.CartProductEntity;
import com.twuc.shopping.repository.CartProductRepository;
import com.twuc.shopping.repository.CartRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    private CartProductRepository cartProductRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @Transactional
    public void createOrder(CartDTO cartDTO) {
        CartEntity cartEntity = CartEntity.builder().build();
        cartRepository.save(cartEntity);

        cartDTO.getCartProductDTOS().forEach(cartProductDTO -> {
                    CartProductEntity cartProductEntity = CartProductEntity
                            .builder()
                            .cartId(cartEntity.getId())
                            .productId(cartProductDTO.getProductDTO().getId())
                            .number(cartProductDTO.getNumber())
                            .build();

                    cartProductRepository.save(cartProductEntity);
                }
        );
    }

    public List<CartDTO> listCarts() {
        return cartRepository.findAll()
                .stream()
                .map(CartEntity::getId)
                .map(this::getOrderInfoById)
                .collect(Collectors.toList());
    }

    public CartDTO getOrderInfoById(String orderId) {
        List<CartProductDTO> productDTOS = cartProductRepository.findAllByCartId(orderId)
                .stream().map(cartProductEntity -> CartProductDTO.builder()
                        .number(cartProductEntity.getNumber())
                        .productDTO(ProductDTO.from(productRepository.findById(cartProductEntity.getProductId()).get()))
                        .build()
                ).collect(Collectors.toList());

        return CartDTO.builder().id(orderId).cartProductDTOS(productDTOS).build();
    }

    @Transactional
    public void deleteOrder(String orderId){
        cartRepository.deleteById(orderId);
        cartProductRepository.deleteAllByCartId(orderId);
    }
}
