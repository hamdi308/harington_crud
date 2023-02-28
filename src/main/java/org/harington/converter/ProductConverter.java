package org.harington.converter;

import lombok.Data;
import org.harington.dto.ProductDto;
import org.harington.model.Product;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

@Data(staticConstructor = "newInstance")
public class ProductConverter implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(Product product) {
        if(Objects.isNull(product)){
            return null;
        }
        return ProductDto.builder()
                .name(product.getName())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .category(product.getCategory())
                .build();
    }
}
