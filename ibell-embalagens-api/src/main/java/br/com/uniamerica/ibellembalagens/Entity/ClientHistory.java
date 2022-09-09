package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class ClientHistory extends AbstractEntity {
    @Getter @Setter
    @ManyToOne
    private Client client;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;
    @Getter @Setter
    private Float quantity;
    @Getter @Setter
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