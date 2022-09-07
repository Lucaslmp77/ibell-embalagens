package br.com.uniamerica.ibellembalagens.Entity;

public class HistoryOutStock {
    private Client client;
    private Product product;

    public HistoryOutStock(Client client, Product product) {
        this.client = client;
        this.product = product;
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
}
