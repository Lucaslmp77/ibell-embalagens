package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_stock_input", schema = "ibell")
public class StockInput extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne
    private Product product;

    @Getter @Setter
    @JoinColumn(name = "id_provider", nullable = false)
    @ManyToOne
    private Provider provider;

    @Getter@Setter
    @Column(name = "observation", length = 255, nullable = true)
    private String observacao;

}
