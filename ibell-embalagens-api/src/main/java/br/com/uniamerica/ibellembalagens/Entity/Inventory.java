package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "td_inventory", schema = "public")
public class Inventory extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Getter @Setter
    @Column(name = "unit_measure", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitMeasure unitMeasure;

    @Getter @Setter
    @Column(name = "the_amount", nullable = false)
    private float theAmount;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
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
