package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_client_history", schema = "public")
public class ClientHistory extends AbstractEntity {
    @Getter @Setter
    @ManyToOne
    private Client client;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;
    @Getter @Setter
    @Column(name = "quantity", nullable = false)
    private Float quantity;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;
}