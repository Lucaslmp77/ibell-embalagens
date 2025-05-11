package br.com.uniamerica.ibellembalagens.repository;

import br.com.uniamerica.ibellembalagens.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product product SET product.active = false WHERE product.id = :id")
    void disable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Product product SET product.active = true WHERE product.id = :id")
    void enabled(@Param("id") Long id);

    @Query("SELECT product FROM Product product WHERE product.active = true")
    List<Product> findByActiveProducts();

    @Query("SELECT product FROM Product product WHERE product.active = false")
    List<Product> findByInactiveProducts();

    @Query("SELECT product.quantity FROM Product product WHERE product.id = :id")
    Float getQuantityByIdProduct(Long id);

}
