package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "td_client_history", schema = "public")
public class ClientHistory extends AbstractEntity {
    @Getter @Setter
    @ManyToOne
    private Client client;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;
    @Getter @Setter
    @Column(name = "quantity", nullable = false)
    private Float quantity;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = true)
    private String observation;

    public ClientHistory() {
    }

    public ClientHistory(Client client, Product product, Float quantity, String observation) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.observation = observation;
    }
}