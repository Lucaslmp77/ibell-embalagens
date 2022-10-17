package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.StockInput;
import br.com.uniamerica.ibellembalagens.Service.StockInputService;
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
public class StockInputController {

    @Autowired
    private StockInputService stockInputService;

    @GetMapping
    public ResponseEntity<Page<StockInput>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.stockInputService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody StockInput stockInput
    ){
        try{
            this.stockInputService.save(stockInput);
            return ResponseEntity.ok().body("Inventario cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
