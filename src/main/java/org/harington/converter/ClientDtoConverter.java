package org.harington.converter;

import lombok.Data;
import org.harington.dto.ClientDto;
import org.harington.model.Client;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Data(staticConstructor = "newInstance")
public class ClientDtoConverter implements Converter<ClientDto, Client> {
    @Override
    public Client convert(ClientDto clientDto) {
        if(Objects.isNull(clientDto)){
            return null;
        }
        return Client.builder()
                .name(clientDto.getName())
                .secondName(clientDto.getSecondName())
                .phone(clientDto.getPhone())
                .email(clientDto.getEmail())
                .address(clientDto.getAddress())
                .Listcommandes(clientDto.getListcommandesDto() != null ?
                        clientDto.getListcommandesDto().stream().map(cmdDto->CommandeDtoConverter.newInstance().convert(cmdDto)).collect(Collectors.toList()) :
                        Collections.emptyList())
                .build();
    }
}
