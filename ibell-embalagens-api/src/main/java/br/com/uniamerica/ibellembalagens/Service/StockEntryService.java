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
    private StockEntryRepository inventoryRepository;

    @Transactional
    public StockEntry save(StockEntry stockEntry) {
        return this.inventoryRepository.save(stockEntry);
    }

    public Page<StockEntry> listAll(Pageable pageable) {
        return this.inventoryRepository.findAll(pageable);
    }

    public Optional<StockEntry> findById(Long id) {
        return this.inventoryRepository.findById(id);
    }

    @Transactional
    public void update(Long id, StockEntry inventory) {
        if(id == inventory.getId()) {
            this.inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id, StockEntry inventory){
        if (id == inventory.getId()) {
            this.inventoryRepository.disable(inventory.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

}
