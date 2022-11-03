package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.Administrator;
import br.com.uniamerica.ibellembalagens.Service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Administrator administrator
    ){
        try{
            this.administratorService.save(administrator);
            return ResponseEntity.ok().body("Administrador cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Administrator>> listAll(

    ){
        return ResponseEntity.ok().body(this.administratorService.listAll());
    }

    @GetMapping("/{idAdm}")
    public ResponseEntity<Administrator> findById(
            @PathVariable("idAdm") Long idCaminhao
    ){
        return ResponseEntity.ok().body(this.administratorService.findById(idCaminhao));
    }

    @PutMapping("/{idAdm}")
    public ResponseEntity<?> update(
            @PathVariable Long idAdm,
            @RequestBody Administrator administrator
    ){
        try{
            this.administratorService.update(idAdm, administrator);
            return ResponseEntity.ok().body("Administrador atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/active/{idAdm}")
    public ResponseEntity<?> disable(
            @PathVariable Long idAdm,
            @RequestBody Administrator administrator
    ){
        try{
            this.administratorService.disable(idAdm, administrator);
            return ResponseEntity.ok().body("Administrador desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
