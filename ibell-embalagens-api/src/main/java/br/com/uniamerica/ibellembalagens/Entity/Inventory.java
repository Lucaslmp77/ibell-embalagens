package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Inventory extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;
    @Getter @Setter
    private UnitMeasure unitMeasure;
    @Getter @Setter
    private float theAmount;
    @Getter @Setter
    private String observation;

    public Inventory() {}

    public Inventory(Product product, UnitMeasure unitMeasure, float theAmount) {
        this.product = product;
        this.unitMeasure = unitMeasure;
        this.theAmount = theAmount;
    }

    public Inventory(Product product, UnitMeasure unitMeasure, float theAmount, String observation) {
        this.product = product;
        this.unitMeasure = unitMeasure;
        this.theAmount = theAmount;
        this.observation = observation;
    }
}
