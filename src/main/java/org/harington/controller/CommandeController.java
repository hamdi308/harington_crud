package org.harington.controller;

import lombok.AllArgsConstructor;
import org.harington.dto.ClientDto;
import org.harington.dto.CommandeDto;
import org.harington.manager.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@AllArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/commandes")
    ResponseEntity<List<CommandeDto>> findAllCommandes() {
        List<CommandeDto> commandes = commandeService.findAllCommandes();
        return ResponseEntity.ok(commandes);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/commandes")
    ResponseEntity<CommandeDto> CreateCommande(@RequestBody CommandeDto commandeDto) {
        return ResponseEntity.ok(commandeService.CreateCommande(commandeDto));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/commandes/update")
    ResponseEntity<CommandeDto> UpdateCommande(@RequestBody CommandeDto commandeDto) {
        return ResponseEntity.ok(commandeService.UpdateCommande(commandeDto));
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/commandes/delete/{id}")
    void deleteCommande(@PathVariable("id") Long id) {
        commandeService.deleteCommande(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/commandes/find/{id}")
    ResponseEntity<CommandeDto> findCommandeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(commandeService.findCommandeById(id));
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/commandes/find/client/{id}")
    ResponseEntity<List<CommandeDto>> findCommandeByClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(commandeService.findCommandeByClient(id));
    }

}
