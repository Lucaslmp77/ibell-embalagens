package br.com.uniamerica.ibellembalagens.Entity;

import java.time.LocalDateTime;

public class HistoryOutStock {

    private Client client;
    private Product product;
    private float amount;
    private LocalDateTime departureDate;
    public String observation;

    public HistoryOutStock() {}

    public HistoryOutStock(Client client, Product product, float amount, LocalDateTime departureDate) {
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.departureDate = departureDate;
    }

    public HistoryOutStock(Client client, Product product, float amount, LocalDateTime departureDate, String observation) {
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.departureDate = departureDate;
        this.observation = observation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
}
