package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_product", schema = "ibell")
public class Product extends AbstractEntity {

    @Getter @Setter
    @Column(name = "code", length = 15, nullable = false, unique = true)
    private String code;

    @Getter @Setter
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String productName;

    @Getter @Setter
    @Column(name = "quantity", length = 10, nullable = false)
    private BigDecimal quantity;

    @Getter @Setter
    @Column(name = "unit_measure", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitMeasure unitMeasure;

    @Getter @Setter
    @Column(name = "cost_value", nullable = false)
    private BigDecimal costValue;

    @Getter @Setter
    @Column(name = "sale_value", nullable = false)
    private BigDecimal saleValue;

    @Getter @Setter
    @JoinColumn(name = "id_provider", nullable = false)
    @ManyToOne
    private Provider provider;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;


}
