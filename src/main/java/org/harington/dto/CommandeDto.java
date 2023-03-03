package org.harington.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.harington.model.Client;
import org.harington.model.Product;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDto {
    private Long id;
    private ClientDto clientDto;
    private List<ProductDto> ListproductDto;
}
