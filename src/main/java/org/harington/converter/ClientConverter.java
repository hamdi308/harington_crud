package org.harington.converter;

import lombok.Data;
import org.harington.dto.ClientDto;
import org.harington.model.Client;
import org.springframework.core.convert.converter.Converter;
import java.util.Objects;
import java.util.stream.Collectors;

@Data(staticConstructor = "newInstance")
public class ClientConverter implements Converter<Client, ClientDto> {
    @Override
    public ClientDto convert(Client client) {
        if (Objects.isNull(client)){
            return null;
        }
        return  ClientDto.builder()
                .name(client.getName())
                .secondName(client.getSecondName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .address(client.getAddress())
                .ListcommandesDto(client.getListcommandes().stream().map(cmd->CommandeConverter.newInstance().convert(cmd)).collect(Collectors.toList()))
                .build();
    }
}
