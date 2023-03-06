package org.harington.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harington.dto.ClientDto;
import org.harington.dto.ProductDto;
import org.harington.manager.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor
@Api(tags = "Products")
public class ProductController {
    private final ProductService productService;
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/products")
    ResponseEntity<List<ProductDto>> findAllProducts() {
        List<ProductDto> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/products")
    ResponseEntity<ProductDto> CreateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.CreateProduct(productDto));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/products/update")
    ResponseEntity<ProductDto> UpdateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.UpdateProduct(productDto));
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/products/delete/{id}")
    void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/products/find/{id}")
    ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/products/find/{category}")
    ResponseEntity<List<ProductDto>> findProductByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(productService.findProductByCategory(category));
    }
}
