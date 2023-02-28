package org.harington.dto;

import lombok.Builder;
import lombok.Data;
import org.harington.model.Client;
import org.harington.model.Product;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class CommandeDto {
    private Client client;
    private List<ProductDto> product;
}
