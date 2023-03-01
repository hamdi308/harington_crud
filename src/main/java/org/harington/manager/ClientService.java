package org.harington.manager;

import lombok.AllArgsConstructor;
import org.harington.converter.ClientConverter;
import org.harington.converter.ClientDtoConverter;
import org.harington.converter.CommandeDtoConverter;
import org.harington.dto.ClientDto;
import org.harington.model.Client;
import org.harington.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    public List<ClientDto> findAllClients(){
        return clientRepository.findAll().stream().map(client -> ClientConverter.newInstance().convert(client)).collect(Collectors.toList());
    }
    public ClientDto CreateClient(ClientDto clientDto){
        Client newClient= clientRepository.save(Objects.requireNonNull(ClientDtoConverter.newInstance().convert(clientDto)));
        return ClientConverter.newInstance().convert(newClient);
    }
    public ClientDto UpdateClient(ClientDto clientDto){
        Optional<Client> updatedClient=clientRepository.findById(clientDto.getId());
        updatedClient.orElseThrow().setName(clientDto.getName());
        updatedClient.orElseThrow().setSecondName(clientDto.getSecondName());
        updatedClient.orElseThrow().setEmail(clientDto.getEmail());
        updatedClient.orElseThrow().setPhone(clientDto.getPhone());
        updatedClient.orElseThrow().setAddress(clientDto.getAddress());
        updatedClient.orElseThrow().setListcommandes(clientDto.getListcommandesDto().stream().map(cmdDto-> CommandeDtoConverter.newInstance().convert(cmdDto)).collect(Collectors.toList()));
       return ClientConverter.newInstance().convert(updatedClient.stream().findFirst().orElseThrow());
    }
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
    public ClientDto findClientById(Long id){
        return ClientConverter.newInstance().convert(clientRepository.findById(id).stream().findFirst().orElseThrow(() -> new IllegalArgumentException("client not found")));
    }
    public ClientDto findClientByNameSecName(String name, String secName){
        return ClientConverter.newInstance().convert(clientRepository.findClientByNameSecName(name,secName));
    }

}
