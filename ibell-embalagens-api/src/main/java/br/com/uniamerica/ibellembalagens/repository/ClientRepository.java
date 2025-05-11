package br.com.uniamerica.ibellembalagens.repository;

import br.com.uniamerica.ibellembalagens.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Modifying
    @Query("UPDATE Client client SET client.active = false WHERE client.id = :id")
    void disable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Client client SET client.active = true WHERE client.id = :id")
    void enabled(@Param("id") Long id);

    @Query("SELECT client FROM Client client WHERE client.active = true")
    List<Client> findByActiveClients();

    @Query("SELECT client FROM Client client WHERE client.active = false")
    List<Client> findByInactiveClients();

    Optional<Client> findByCnpjCpf(String cnpjCpf);
}
