package br.com.uniamerica.ibellembalagens.repository;

import br.com.uniamerica.ibellembalagens.entity.StockInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StockInputRepository extends JpaRepository<StockInput, Long> {

    @Modifying
    @Query("UPDATE StockInput stockInput SET stockInput.active = false WHERE stockInput.id = :id")
    void disable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE StockInput stockInput SET stockInput.active = true WHERE stockInput.id = :id")
    void enabled(@Param("id") Long id);

    @Query("FROM StockInput stockInput WHERE stockInput.product.id = :idProduct")
    List<StockInput> findByProductInStockInput(@Param("idProduct") Long idProduct);

    @Query("FROM StockInput stockInput WHERE stockInput.provider.id = :idProvider")
    List<StockInput> findByProviderInStockInput(@Param("idProvider") Long idProvider);


    @Query("SELECT stockInput FROM StockInput stockInput WHERE stockInput.active = true")
    ArrayList<StockInput> findByActiveStockInputs();

    @Query("SELECT stockInput FROM StockInput stockInput WHERE stockInput.active = false")
    List<StockInput> findByInactiveStockInputs();

    @Query("SELECT SUM(stockInput.inputQuantity) FROM StockInput stockInput WHERE stockInput.product.id = :idProduct")
    Float getSumInputQuantity(@Param("idProduct") Long idProduct);



    @Query("SELECT (SUM(stockInput.inputQuantity * stockInput.costValue)) " +
            "FROM StockInput stockInput WHERE stockInput.product.id = :idProduct AND stockInput.active = TRUE")
    Float updateNewCostValue(@Param("idProduct") Long idProduct);

}
