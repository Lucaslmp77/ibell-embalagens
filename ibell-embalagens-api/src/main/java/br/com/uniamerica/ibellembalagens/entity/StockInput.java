package br.com.uniamerica.ibellembalagens.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class StockInput extends AbstractEntity {

    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne
    private Product product;

    @JoinColumn(name = "id_provider", nullable = false)
    @ManyToOne
    private Provider provider;

    @Column(name = "cost_value", nullable = false)
    private Float costValue;

    @Column(name = "input_quantity", length = 25, nullable = false)
    private Float inputQuantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "date_entry", length = 25, nullable = false)
    private Date dateEntry;

    @Column(name = "observation", length = 255, nullable = true)
    private String observation;

}
