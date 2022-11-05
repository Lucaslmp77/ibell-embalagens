package br.com.uniamerica.ibellembalagens.Repository;

import br.com.uniamerica.ibellembalagens.Entity.StockInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInputRepository extends JpaRepository<StockInput, Long> {

    @Modifying
    @Query("UPDATE StockInput stockInput SET stockInput.active = false WHERE stockInput.id = :id")
    public void disable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE StockInput stockInput SET stockInput.active = true WHERE stockInput.id = :id")
    public void enabled(@Param("id") Long id);

    @Query("FROM StockInput stockInput WHERE stockInput.product.id = :idProduct")
    public List<StockInput> findByProductInStockInput(@Param("idProduct") Long idProduct);

    @Query("FROM StockInput stockInput WHERE stockInput.provider.id = :idProvider")
    public List<StockInput> findByProviderInStockInput(@Param("idProvider") Long idProvider);

}
