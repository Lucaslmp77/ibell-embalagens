package br.com.uniamerica.ibellembalagens.repository;

import br.com.uniamerica.ibellembalagens.entity.StockOutput;
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
    void disable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE StockOutput stockOutput SET stockOutput.active = true WHERE stockOutput.id = :id")
    void enabled(@Param("id") Long id);

    @Query("FROM StockOutput stockOutput WHERE stockOutput.client.id = :idClient")
    List<StockOutput> findByClientInStockOutput(@Param("idClient") Long idClient);

    @Query("FROM StockOutput stockOutput WHERE stockOutput.product.id = :idProduct")
    List<StockOutput> findByProductInStockOutput(@Param("idProduct") Long idProduct);

    @Query("SELECT stockOutput FROM StockOutput stockOutput WHERE stockOutput.active = true")
    List<StockOutput> findByActiveStockOutputs();

    @Query("SELECT stockOutput FROM StockOutput stockOutput WHERE stockOutput.active = false")
    List<StockOutput> findByInactiveStockOutputs();

    @Query("SELECT SUM(stockOutput.quantityOutput) FROM StockOutput stockOutput WHERE stockOutput.product.id = :idProduct")
    Float getSumOutputQuantity(@Param("idProduct") Long idProduct);

}
