package br.com.uniamerica.ibellembalagens.Repository;

import br.com.uniamerica.ibellembalagens.Entity.StockOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockOutputRepository extends JpaRepository<StockOutput, Long> {

    @Modifying
    @Query("UPDATE StockOutput stockOutput SET stockOutput.active = false WHERE stockOutput.id = :id")
    public void disable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE StockOutput stockOutput SET stockOutput.active = true WHERE stockOutput.id = :id")
    public void enabled(@Param("id") Long id);

    @Query("FROM StockOutput stockOutput WHERE stockOutput.client.id = :idClient")
    public List<StockOutput> findByClientInStockOutput(@Param("idClient") Long idClient);

}
