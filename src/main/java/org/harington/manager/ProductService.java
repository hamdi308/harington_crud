package org.harington.manager;

import lombok.AllArgsConstructor;
import org.harington.converter.*;
import org.harington.dto.ProductDto;
import org.harington.model.Product;
import org.harington.repository.ProductRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<ProductDto> findAllProducts(){
        return productRepository.findAll().stream().map(prdct -> ProductConverter.newInstance().convert(prdct)).collect(Collectors.toList());
    }
    public ProductDto CreateProduct(ProductDto productDto){
        Product newProduct= productRepository.save(ProductDtoConverter.newInstance().convert(productDto));
        return ProductConverter.newInstance().convert(newProduct);
    }
    public ProductDto UpdateProduct(ProductDto productDto){
        Optional<Product> updatedProduct=productRepository.findById(productDto.getId());
        updatedProduct.orElseThrow().setName(productDto.getName());
        updatedProduct.orElseThrow().setQuantity(productDto.getQuantity());
        updatedProduct.orElseThrow().setDescription(productDto.getDescription());
        updatedProduct.orElseThrow().setCategory(productDto.getCategory());
        return ProductConverter.newInstance().convert(updatedProduct.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("failed")));
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    public ProductDto findProductById(Long id){
        return ProductConverter.newInstance().convert(productRepository.findById(id).stream().findFirst().orElseThrow(() -> new IllegalArgumentException("product not found")));
    }
    public List<ProductDto> findProductByCategory(String category){
        return productRepository.findProductByCategory(category).stream().map(prdct->ProductConverter.newInstance().convert(prdct)).collect(Collectors.toList());
    }

}
