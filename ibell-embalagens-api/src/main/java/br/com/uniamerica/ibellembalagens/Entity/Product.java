package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Product extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ProductName productName;
    @Getter @Setter
    private String code;
    @Getter @Setter
    private UnitMeasure unitMeasure;
    @Getter @Setter
    private Float costValue;
    @Getter @Setter
    private Float saleValue;
    @Getter @Setter
    private LocalDateTime dateRegistration;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Provider provider;
    @Getter @Setter
    private String observation;

    public Product() {}

    public Product(ProductName productName, String code, UnitMeasure unitMeasure, Float costValue, Float saleValue, LocalDateTime dateRegistration, Provider provider) {
        this.productName = productName;
        this.code = code;
        this.unitMeasure = unitMeasure;
        this.costValue = costValue;
        this.saleValue = saleValue;
        this.dateRegistration = dateRegistration;
        this.provider = provider;
    }

    public Product(ProductName productName, String code, UnitMeasure unitMeasure, Float costValue, Float saleValue, LocalDateTime dateRegistration, Provider provider, String observation) {
        this.productName = productName;
        this.code = code;
        this.unitMeasure = unitMeasure;
        this.costValue = costValue;
        this.saleValue = saleValue;
        this.dateRegistration = dateRegistration;
        this.provider = provider;
        this.observation = observation;
    }
}
