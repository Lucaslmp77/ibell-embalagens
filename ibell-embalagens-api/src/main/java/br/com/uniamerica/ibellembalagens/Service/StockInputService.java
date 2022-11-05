package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.StockInput;
import br.com.uniamerica.ibellembalagens.Repository.StockInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockInputService {

    @Autowired
    private StockInputRepository stockInputRepository;

    @Transactional
    public StockInput save(StockInput stockInput) {
        return this.stockInputRepository.save(stockInput);
    }

    public List<StockInput> listAll() {
        return this.stockInputRepository.findAll();
    }

    public StockInput findById(Long id) {
        return this.stockInputRepository.findById(id).orElse(new StockInput());
    }

    @Transactional
    public void update(Long id, StockInput stockInput) {
        if(id == stockInput.getId()) {
            this.stockInputRepository.save(stockInput);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var stockInput = this.stockInputRepository.findById(id);
        if (id == stockInput.get().getId()) {
            this.stockInputRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void enabled(Long id){
        var stockInput = this.stockInputRepository.findById(id);
        if (id == stockInput.get().getId()) {
            this.stockInputRepository.enabled(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<StockInput> findByProductInStockInput(Long id) {
        return this.stockInputRepository.findByProductInStockInput(id);
    }

    public List<StockInput> findByProviderInStockInput(Long id) {
        return this.stockInputRepository.findByProviderInStockInput(id);

    }

}
