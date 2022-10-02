package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.Inventory;
import br.com.uniamerica.ibellembalagens.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Page<Inventory>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.inventoryService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Inventory inventory
    ){
        try{
            this.inventoryService.save(inventory);
            return ResponseEntity.ok().body("Inventario cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
