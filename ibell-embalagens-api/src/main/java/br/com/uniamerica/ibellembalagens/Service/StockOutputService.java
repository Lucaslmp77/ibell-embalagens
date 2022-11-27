package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.StockOutput;
import br.com.uniamerica.ibellembalagens.Repository.StockOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockOutputService {

    @Autowired
    private StockOutputRepository stockOutputRepository;

    @Transactional
    public StockOutput save(StockOutput stockOutput) {
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
        if(id == stockOutput.getId()) {
            this.stockOutputRepository.save(stockOutput);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var stockOutput = this.stockOutputRepository.findById(id);
        if (id == stockOutput.get().getId()) {
            this.stockOutputRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void enabled(Long id){
        var stockOutput = this.stockOutputRepository.findById(id);
        if (id == stockOutput.get().getId()) {
            this.stockOutputRepository.enabled(id);
        }
        else {
            throw new RuntimeException();
        }
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
