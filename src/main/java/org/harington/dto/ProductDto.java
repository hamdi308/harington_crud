package org.harington.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class ProductDto {
    private String name;
    private Integer quantity;
    private String description;
}
