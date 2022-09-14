package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "td_historic_exit_storage", schema = "public")
public class HistoricExitStorage extends AbstractEntity {
    @Getter @Setter
    @Column(name = "historic", length = 25, nullable = false)
    private String Historic;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

}
