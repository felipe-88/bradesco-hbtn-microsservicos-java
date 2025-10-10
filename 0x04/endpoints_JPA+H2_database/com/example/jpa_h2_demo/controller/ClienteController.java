package com.example.jpa_h2_demo.controller;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteRepository.save(cliente));
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        return ResponseEntity.ok(this.clienteRepository.findAll());
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        return ResponseEntity.ok(this.clienteRepository.findById(idClient.intValue()).get());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        this.clienteRepository.deleteById(idClient.intValue());
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Cliente cliDb = this.clienteRepository.findById(id.intValue()).get();
        cliDb.setNome(cliente.getNome());
        cliDb.setIdade(cliente.getIdade());
        cliDb.setEmail(cliente.getEmail());
        cliDb.setEnderecos(cliente.getEnderecos());
        cliDb.setTelefones(cliente.getTelefones());
        this.clienteRepository.save(cliDb);
    }
}
