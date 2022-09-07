package br.com.uniamerica.ibellembalagens.Entity;

public class ClientHistory extends AbstractEntity {
    private Client client;
    private Product product;
    private Float quantity;
    private String observation;

    public ClientHistory() {
    }

    ;

    public ClientHistory(Client client, Product product, Float quantity, String observation) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.observation = observation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduto() {
        return product;
    }

    public void setProduto(Product product) {
        this.product = product;
    }

    public Float getQuantidade() {
        return quantity;
    }

    public void setQuantidade(Float quantity) {
        this.quantity = quantity;
    }

    public String getObservacao() {
        return observation;
    }

    public void setObservacao(String observation) {
        this.observation = observation;
    }
}