package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_stock_output", schema = "ibell")
public class StockOutput extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "id_client", nullable = false)
    @ManyToOne
    private Client client;

    @Getter @Setter
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne
    private Product product;

    @Getter @Setter
    @Column(name = "quantidade_saida", length = 25, nullable = false)
    private BigDecimal quantityOutput;

    @Getter @Setter
    @Column(name = "valor_venda", length = 25, nullable = false)
    private BigDecimal saleValue;

    @Getter @Setter
    @Column(name = "data_saida", length = 25, nullable = false)
    private LocalDateTime departureDate;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = true)
    private String observation;

}
