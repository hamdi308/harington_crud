package org.harington.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    private Long id;
    private String name;
    private Integer quantity;

}
