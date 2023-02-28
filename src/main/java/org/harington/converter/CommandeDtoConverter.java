package org.harington.converter;

import lombok.Data;
import org.harington.dto.CommandeDto;
import org.harington.model.Commande;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
import java.util.stream.Collectors;

@Data(staticConstructor = "newInstance")
public class CommandeDtoConverter implements Converter<CommandeDto, Commande> {
    @Override
    public Commande convert(CommandeDto commandeDto) {
        if(Objects.isNull(commandeDto)){
            return null;
        }
        return Commande.builder()
                .client(ClientDtoConverter.newInstance().convert(commandeDto.getClientDto()))
                .product(commandeDto.getListproductDto().stream().map(prdctDto->ProductDtoConverter.newInstance().convert(prdctDto)).collect(Collectors.toList()))
                .build();
    }
}
