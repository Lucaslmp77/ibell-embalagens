package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Entity.Product;
import br.com.uniamerica.ibellembalagens.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Product product
    ){
        try{
            this.productService.save(product);
            return ResponseEntity.ok().body("Produto cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> listAll(

    ){
        return ResponseEntity.ok().body(this.productService.listAll());
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> findById(
            @PathVariable("idProduct") Long idProduct
    ){
        return ResponseEntity.ok().body(this.productService.findById(idProduct));
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<?> update(
            @PathVariable Long idProduct,
            @RequestBody Product product
    ){
        try{
            this.productService.update(idProduct, product);
            return ResponseEntity.ok().body("Produto atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/active/{idProduct}")
    public ResponseEntity<?> disable(
            @PathVariable Long idProduct,
            @RequestBody Product product
    ){
        try{
            this.productService.disable(idProduct, product);
            return ResponseEntity.ok().body("Produto desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
