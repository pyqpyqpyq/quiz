package com.twuc.shopping.controller;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.twuc.shopping.dto.ProductDTO;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private static final Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductEntity productEntity = MAPPER.map(productDTO, ProductEntity.class);
        return MAPPER.map(productService.addProduct(productEntity), ProductDTO.class);
    }


    //    @GetMapping("/product/list")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<ProductDTO> listAllProducts() {
//        List<ProductEntity> productEntities = productService.listProduct();
//        return productEntities.stream().map(productEntity -> ProductDTO
//                .builder()
//                .name(productEntity.getName())
//                .avatar(productEntity.getAvatar())
//                .price(productEntity.getPrice())
//                .unit(productEntity.getUnit())
//                .build()).collect(Collectors.toList());
//    }
    @GetMapping("/product/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> listAllProducts() {
        List<ProductEntity> productEntities = productService.listProduct();
        return MAPPER.map(productEntities,List.class);
//        通过return指定，返回list的object，List转List
    }

}
