package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class ProductName extends AbstractEntity {
    @Getter @Setter
    private String name;
}
