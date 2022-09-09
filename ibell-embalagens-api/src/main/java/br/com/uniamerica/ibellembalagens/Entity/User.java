package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity{

    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;



}
