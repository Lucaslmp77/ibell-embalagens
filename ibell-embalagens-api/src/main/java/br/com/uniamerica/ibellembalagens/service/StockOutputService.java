package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.StockOutput;
import br.com.uniamerica.ibellembalagens.repository.ProductRepository;
import br.com.uniamerica.ibellembalagens.repository.StockInputRepository;
import br.com.uniamerica.ibellembalagens.repository.StockOutputRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StockOutputService {

    private final StockOutputRepository stockOutputRepository;

    private final StockInputRepository stockInputRepository;

    private final ProductRepository productRepository;

    @Transactional
    public StockOutput save(StockOutput stockOutput) {
        this.stockOutputRepository.save(stockOutput);

        var product = this.productRepository.findById(stockOutput.getProduct().getId()).get();
        var quantity = this.productRepository.getQuantityByIdProduct(stockOutput.getProduct().getId());
        float outputQuantity = stockOutput.getQuantityOutput();
        var sumOutput = this.stockOutputRepository.getSumOutputQuantity(stockOutput.getProduct().getId());
        var sumInput = this.stockInputRepository.getSumInputQuantity(stockOutput.getProduct().getId());


        if (quantity > outputQuantity || quantity == outputQuantity) {
            var newValue = sumInput - sumOutput;
            product.setQuantity(newValue);
            this.productRepository.save(product);
        } else {
            throw new RuntimeException();
        }

        return this.stockOutputRepository.save(stockOutput);
    }

    public List<StockOutput> listAll() {
        return this.stockOutputRepository.findAll();
    }

    public StockOutput findById(Long id) {
        return this.stockOutputRepository.findById(id).orElse(new StockOutput());
    }

    @Transactional
    public void update(Long id, StockOutput stockOutput) {
        if(Objects.equals(id, stockOutput.getId())) {
            this.stockOutputRepository.save(stockOutput);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var stockOutput = this.stockOutputRepository.findById(id);
        if (id.equals(stockOutput.get().getId())) {
            this.stockOutputRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void enabled(Long id){
        var stockOutput = this.stockOutputRepository.findById(id);
        if (id.equals(stockOutput.get().getId())) {
            this.stockOutputRepository.enabled(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<StockOutput> findByProductInStockOutput(Long id) {
        return this.stockOutputRepository.findByProductInStockOutput(id);
    }

    public List<StockOutput> findByClientInStockOutput(Long id) {
        return this.stockOutputRepository.findByClientInStockOutput(id);
    }


    public List<StockOutput> findByActiveStockOutputs() {
        return this.stockOutputRepository.findByActiveStockOutputs();
    }

    public List<StockOutput> findByInactiveStockOutputs() {
        return this.stockOutputRepository.findByInactiveStockOutputs();
    }

}
