package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.StockInput;
import br.com.uniamerica.ibellembalagens.Repository.StockInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StockInputService {

    @Autowired
    private StockInputRepository stockInputRepository;

    @Transactional
    public StockInput save(StockInput stockInput) {
        return this.stockInputRepository.save(stockInput);
    }
    public Page<StockInput> listAll(Pageable pageable) {
        return this.stockInputRepository.findAll(pageable);
    }

    public Optional<StockInput> findById(Long id) {
        return this.stockInputRepository.findById(id);
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
    public void disable(Long id, StockInput stockInput){
        if (id == stockInput.getId()) {
            this.stockInputRepository.disable(stockInput.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

}
