package org.harington.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "Clients")
public class ClientController {
    private final ClientService clientService;
    @ApiOperation("find all clients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved clients"),
            @ApiResponse(code = 404, message = "No clients found")
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients")
    ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clients = clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }
    @ApiOperation(value = "Create a new client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created client"),
            @ApiResponse(code = 400, message = "Invalid request body for client")
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients")
    ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.CreateClient(clientDto));
    }
    @ApiOperation(value = "Update an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated client"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/update")
    ResponseEntity<ClientDto> UpdateClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.UpdateClient(clientDto));
    }
    @ApiOperation(value = "Delete an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted client"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/delete/{id}")
    void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }
    @ApiOperation(value = "Find a client by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved client"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/find/{id}")
    ResponseEntity<ClientDto> findClientById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.findClientById(id));
    }
    @ApiOperation(value = "Find a client by name and second name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully getting client by name and secondName"),
            @ApiResponse(code = 404, message = "Client not found")
    })
     @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/clients/find/{name}/{secName}")
    ResponseEntity<ClientDto> findClientByNameSecName(@PathVariable("name") String name,@PathVariable("secName") String secName) {
        return ResponseEntity.ok(clientService.findClientByNameSecName(name,secName));
    }

}
