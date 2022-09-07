package br.com.uniamerica.ibellembalagens.Entity;

public class HistoricExitStorage extends AbstractEntity {
    private String Historic;
    private Client client;
    private Product product;

    public String getHistoric() {
        return Historic;
    }

    public void setHistoric(String historic) {
        Historic = historic;
    }
}
