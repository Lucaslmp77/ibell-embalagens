package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_stock_input", schema = "ibell")
public class StockInput extends AbstractEntity {

    @Getter@Setter
    @ManyToMany
    @JoinTable(name = "stockEntry_product", schema = "ibell",
            joinColumns = @JoinColumn(name = "id_stockEntry"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> productList;

    @Getter@Setter
    @ManyToMany
    @JoinTable(name = "stockEntry_provider", schema = "ibell",
            joinColumns = @JoinColumn(name = "id_stockEntry"),
            inverseJoinColumns = @JoinColumn(name = "id_provider"))
    private List<Provider> providerList;

    @Getter@Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observacao;

}
