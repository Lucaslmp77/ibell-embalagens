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

    @Getter @Setter
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Getter @Setter
    @JoinColumn(name = "id_provider", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Provider provider;

    @Getter@Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observacao;

}
