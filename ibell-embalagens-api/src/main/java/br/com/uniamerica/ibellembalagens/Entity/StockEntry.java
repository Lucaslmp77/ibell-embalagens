package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_inventory", schema = "ibell")
public class StockEntry extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Getter@Setter
    @JoinColumn(name = "id_provider", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Provider provider;

    @Getter@Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observacao;

}
