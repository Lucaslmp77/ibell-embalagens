package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.StockInput;
import br.com.uniamerica.ibellembalagens.Service.StockInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stock-input")
public class StockInputController {

    @Autowired
    private StockInputService stockInputService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody StockInput stockInput
    ){
        try{
            this.stockInputService.save(stockInput);
            return ResponseEntity.ok().body("Entrada de estoque cadastrada!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<StockInput>> listAll(

    ){
        return ResponseEntity.ok().body(this.stockInputService.listAll());
    }

    @GetMapping("/{idStockInput}")
    public ResponseEntity<StockInput> findById(
            @PathVariable("idStockInput") Long idStockInput
    ){
        return ResponseEntity.ok().body(this.stockInputService.findById(idStockInput));
    }

    @PutMapping("/{idStockInput}")
    public ResponseEntity<?> update(
            @PathVariable Long idStockInput,
            @RequestBody StockInput stockInput
    ){
        try{
            this.stockInputService.update(idStockInput, stockInput);
            return ResponseEntity.ok().body("Entrada de estoque atualizada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/active/{idStockInput}")
    public ResponseEntity<?> disable(
            @PathVariable Long idStockInput,
            @RequestBody StockInput stockInput
    ){
        try{
            this.stockInputService.disable(idStockInput, stockInput);
            return ResponseEntity.ok().body("Entrada de estoque desativada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<?> findByProductInStockInput(@PathVariable("idProduct") Long idProduct) {
        return ResponseEntity.ok().body(this.stockInputService.findByProductInStockInput(idProduct));
    }

    @GetMapping("/provider/{idProvider}")
    public ResponseEntity<?> findByProviderInStockInput(@PathVariable("idProvider") Long idProvider) {
        return ResponseEntity.ok().body(this.stockInputService.findByProviderInStockInput(idProvider));
    }

}
