package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_stock_output", schema = "ibell")
public class StockOutput extends AbstractEntity {

    @Getter@Setter
    @ManyToMany
    @JoinTable(name = "stockOutput_client", schema = "ibell",
            joinColumns = @JoinColumn(name = "id_stockOutput"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private List<Client> clientList;

    @Getter@Setter
    @ManyToMany
    @JoinTable(name = "stockOutput_product", schema = "ibell",
            joinColumns = @JoinColumn(name = "id_stockOutput"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> productList;

    @Getter @Setter
    @Column(name = "departure_date", length = 25, nullable = false)
    private LocalDateTime departureDate;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

}
