package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.StockEntry;
import br.com.uniamerica.ibellembalagens.Repository.StockEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StockEntryService {

    @Autowired
    private StockEntryRepository stockEntryRepository;

    @Transactional
    public StockEntry save(StockEntry stockEntry) {
        return this.stockEntryRepository.save(stockEntry);
    }

    public Page<StockEntry> listAll(Pageable pageable) {
        return this.stockEntryRepository.findAll(pageable);
    }

    public Optional<StockEntry> findById(Long id) {
        return this.stockEntryRepository.findById(id);
    }

    @Transactional
    public void update(Long id, StockEntry stockEntry) {
        if(id == stockEntry.getId()) {
            this.stockEntryRepository.save(stockEntry);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id, StockEntry inventory){
        if (id == inventory.getId()) {
            this.stockEntryRepository.disable(inventory.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

}
