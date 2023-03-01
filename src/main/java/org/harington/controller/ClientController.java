package org.harington.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harington.dto.ClientDto;
import org.harington.manager.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Slf4j
@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients")
    ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clients = clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients")
    ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.CreateClient(clientDto));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/update")
    ResponseEntity<ClientDto> UpdateClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.UpdateClient(clientDto));
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/delete/{id}")
    void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/find/{id}")
    ResponseEntity<ClientDto> findClientById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.findClientById(id));
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/find/{id}")
    ResponseEntity<ClientDto> findClientByNameSecName(@PathVariable("name") String name,@PathVariable("secName") String secName) {
        return ResponseEntity.ok(clientService.findClientByNameSecName(name,secName));
    }

}
