package org.harington.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
@Builder
public class ClientDto {
    private String name;
    private String secondName;
    private String email;
    private String phone;
    private String address;
    private List<CommandeDto> commandeDto;
}
