package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.Client;
import br.com.uniamerica.ibellembalagens.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Client client
    ){
        try{
            this.clientService.save(client);
            return ResponseEntity.ok().body("Cliente cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> listAll(

    ){
        return ResponseEntity.ok().body(this.clientService.listAll());
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<Client> findById(
            @PathVariable("idClient") Long idClient
    ){
        return ResponseEntity.ok().body(this.clientService.findById(idClient));
    }

    @PutMapping("/{idClient}")
    public ResponseEntity<?> update(
            @PathVariable Long idClient,
            @RequestBody Client client
    ){
        try{
            this.clientService.update(idClient, client);
            return ResponseEntity.ok().body("Cliente atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idClient}")
    public ResponseEntity<?> disable(
            @PathVariable Long idClient,
            @RequestBody Client client
    ){
        try{
            this.clientService.disable(idClient, client);
            return ResponseEntity.ok().body("Cliente desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
