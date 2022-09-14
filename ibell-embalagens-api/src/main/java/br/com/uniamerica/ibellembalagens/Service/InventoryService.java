package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.Inventory;
import br.com.uniamerica.ibellembalagens.Entity.Product;
import br.com.uniamerica.ibellembalagens.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public Inventory save(Inventory inventory) {
        return this.inventoryRepository.save(inventory);
    }

    public Page<Inventory> listAll(Pageable pageable) {
        return this.inventoryRepository.findAll(pageable);
    }

    public Optional<Inventory> findById(Long id) {
        return this.inventoryRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Inventory inventory) {
        if(id == inventory.getId()) {
            this.inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException();
        }
    }
}
