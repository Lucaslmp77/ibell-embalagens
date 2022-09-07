package br.com.uniamerica.ibellembalagens.Entity;

import java.time.LocalDateTime;

public class Product extends AbstractEntity {

    private ProductName productName;

    private String code;

    private UnitMeasure unitMeasure;

    private Float costValue;

    private Float saleValue;

    private LocalDateTime dateRegistration;

    private Provider provider;

    private String observation;


    public ProductName getProductName() {
        return productName;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UnitMeasure getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(UnitMeasure unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public Float getCostValue() {
        return costValue;
    }

    public void setCostValue(Float costValue) {
        this.costValue = costValue;
    }

    public Float getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Float saleValue) {
        this.saleValue = saleValue;
    }

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
