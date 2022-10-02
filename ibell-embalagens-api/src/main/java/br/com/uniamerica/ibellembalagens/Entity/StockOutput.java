package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_stock_output", schema = "ibell")
public class StockOutput extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "id_client", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    @Getter @Setter
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Getter @Setter
    @Column(name = "departure_date", length = 25, nullable = false)
    private LocalDateTime departureDate;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

}
