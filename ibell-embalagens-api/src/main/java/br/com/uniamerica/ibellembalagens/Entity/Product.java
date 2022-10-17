package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product", schema = "ibell")
public class Product extends AbstractEntity {

    @Getter @Setter
    @Column(name = "code", length = 25, nullable = false, unique = true)
    private String code;

    @Getter @Setter
    @Column(name = "name", length = 25, nullable = false, unique = true)
    private String productName;

    @Getter @Setter
    @Column(name = "quantity", length = 10, nullable = false)
    private float quantity;

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
    @ManyToMany
    @JoinTable(name = "product_provider", schema = "ibell",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_provider"))
    private List<Provider> providerList;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    @Getter @Setter
    @ManyToMany(mappedBy = "productList")
    private List<StockOutput> stockOutputList;

    @Getter @Setter
    @ManyToMany(mappedBy = "productList")
    private List<StockEntry> stockEntryList;

}
