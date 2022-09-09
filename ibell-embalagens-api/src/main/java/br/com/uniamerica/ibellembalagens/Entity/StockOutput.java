package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StockOutput extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;
    @Getter @Setter
    private float amount;
    @Getter @Setter
    private LocalDateTime departureDate;
    @Getter @Setter
    private String observation;

    public StockOutput() {}

    public StockOutput(Client client, Product product, float amount, LocalDateTime departureDate) {
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.departureDate = departureDate;
    }

    public StockOutput(Client client, Product product, float amount, LocalDateTime departureDate, String observation) {
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.departureDate = departureDate;
        this.observation = observation;
    }
}
