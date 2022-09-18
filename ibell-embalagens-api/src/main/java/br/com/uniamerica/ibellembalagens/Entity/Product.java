package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_product", schema = "public")
public class Product extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Column(name = "product_name", length = 25, nullable = false, unique = true)
    private ProductName productName;

    @Getter @Setter
    @Column(name = "code", length = 25, nullable = false, unique = true)
    private String code;

    @Getter @Setter
    @Column(name = "unit_measure", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitMeasure unitMeasure;

    @Getter @Setter
    @Column(name = "cost_value", nullable = false)
    private Float costValue;

    @Getter @Setter
    @Column(name = "sale_value", nullable = false)
    private Float saleValue;

    @Getter @Setter
    @Column(name = "date_registration", length = 25, nullable = false)
    private LocalDateTime dateRegistration;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Provider provider;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    public Product(ProductName productName, String code, UnitMeasure unitMeasure, Float costValue, Float saleValue,
                   LocalDateTime dateRegistration, Provider provider) {
        this.productName = productName;
        this.code = code;
        this.unitMeasure = unitMeasure;
        this.costValue = costValue;
        this.saleValue = saleValue;
        this.dateRegistration = dateRegistration;
        this.provider = provider;
    }
}
