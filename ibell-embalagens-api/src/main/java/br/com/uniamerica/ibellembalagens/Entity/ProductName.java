package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_product_name", schema = "public")
public class ProductName extends AbstractEntity {

    @Getter @Setter
    @Column(name = "name", length = 25, nullable = false)
    private String name;
}
