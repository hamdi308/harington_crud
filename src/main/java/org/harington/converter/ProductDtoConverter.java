package org.harington.converter;

import lombok.Data;
import org.harington.dto.ProductDto;
import org.harington.model.Product;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

@Data(staticConstructor = "newInstance")
public class ProductDtoConverter implements Converter<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        if (Objects.isNull(productDto)){
            return null;
        }
        return Product.builder()
                .name(productDto.getName())
                .quantity(productDto.getQuantity())
                .description(productDto.getDescription())
                .build();
    }
}
