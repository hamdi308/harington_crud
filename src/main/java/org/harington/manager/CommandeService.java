package org.harington.manager;

import lombok.AllArgsConstructor;
import org.harington.converter.*;
import org.harington.dto.CommandeDto;
import org.harington.model.Commande;
import org.harington.repository.CommandeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;
    public List<CommandeDto> findAllCommandes(){
        return commandeRepository.findAll().stream().map(cmd -> CommandeConverter.newInstance().convert(cmd)).collect(Collectors.toList());
    }
    public CommandeDto CreateCommande(CommandeDto commandeDto){
        Commande newCommande= commandeRepository.save(CommandeDtoConverter.newInstance().convert(commandeDto));
        return CommandeConverter.newInstance().convert(newCommande);
    }
    public CommandeDto UpdateCommande(CommandeDto commandeDto){
        Optional<Commande> updatedCommande=commandeRepository.findById(commandeDto.getId());
        updatedCommande.orElseThrow().setProduct(commandeDto.getListproductDto().stream().map(prdctDto->ProductDtoConverter.newInstance().convert(prdctDto)).collect(Collectors.toList()));
        updatedCommande.orElseThrow().setClient(ClientDtoConverter.newInstance().convert(commandeDto.getClientDto()));
        return CommandeConverter.newInstance().convert(updatedCommande.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("failed")));
    }
    public void deleteCommande(Long id){
        commandeRepository.deleteById(id);
    }
    public CommandeDto findCommandeById(Long id){
        return CommandeConverter.newInstance().convert(commandeRepository.findById(id).stream().findFirst().orElseThrow(() -> new IllegalArgumentException("commande not found")));
    }
    public List<CommandeDto> findCommandeByClient(Long id){
        return commandeRepository.findCommandeByClient(id).stream().map(cmd->CommandeConverter.newInstance().convert(cmd)).collect(Collectors.toList());
    }

}
