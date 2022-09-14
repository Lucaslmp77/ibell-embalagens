package br.com.uniamerica.ibellembalagens.Repository;

import br.com.uniamerica.ibellembalagens.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {



}
