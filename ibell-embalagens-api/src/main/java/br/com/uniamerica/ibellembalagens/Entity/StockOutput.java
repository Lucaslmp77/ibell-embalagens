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
@Table(name = "td_stock_output", schema = "public")
public class StockOutput extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Getter @Setter
    @Column(name = "amount", nullable = false)
    private float amount;

    @Getter @Setter
    @Column(name = "departure_date", length = 25, nullable = false)
    private LocalDateTime departureDate;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    public StockOutput(Client client, Product product, float amount, LocalDateTime departureDate) {
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.departureDate = departureDate;
    }
}
