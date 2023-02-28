package org.harington.converter;

import lombok.Data;
import org.harington.dto.CommandeDto;
import org.harington.model.Commande;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
import java.util.stream.Collectors;

@Data(staticConstructor = "newInstance")
public class CommandeConverter implements Converter<Commande, CommandeDto> {
    @Override
    public CommandeDto convert(Commande commande) {
        if(Objects.isNull(commande)){
            return null;
        }
        return CommandeDto.builder()
                .clientDto(ClientConverter.newInstance().convert(commande.getClient()))
                .ListproductDto(commande.getProduct().stream().map(prdct->ProductConverter.newInstance().convert(prdct)).collect(Collectors.toList()))
                .build();
    }
}
