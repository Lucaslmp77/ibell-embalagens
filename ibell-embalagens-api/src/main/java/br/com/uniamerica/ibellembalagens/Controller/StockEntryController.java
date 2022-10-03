package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.StockEntry;
import br.com.uniamerica.ibellembalagens.Service.StockEntryService;
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
public class StockEntryController {

    @Autowired
    private StockEntryService stockEntryService;

    @GetMapping
    public ResponseEntity<Page<StockEntry>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.stockEntryService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody StockEntry stockEntry
    ){
        try{
            this.stockEntryService.save(stockEntry);
            return ResponseEntity.ok().body("Inventario cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
