package br.com.uniamerica.ibellembalagens.Repository;

import br.com.uniamerica.ibellembalagens.Entity.StockOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockOutputRepository extends JpaRepository<StockOutput, Long> {

    @Modifying
    @Query("UPDATE StockOutput stockOutput SET stockOutput.active = false WHERE stockOutput.id = :id")
    public void disable(@Param("id") Long id);

}
