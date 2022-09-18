package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_inventory", schema = "public")
public class Inventory extends AbstractEntity {
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Getter @Setter
    @Column(name = "quantity", length = 25, nullable = false)
    private int quantity;
}
