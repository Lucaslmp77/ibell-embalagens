package br.com.uniamerica.ibellembalagens.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Administrator extends AbstractEntity {

    // FALHA 1: Não valida formato (permite caracteres especiais inválidos como @#$%)
    @Length(min = 3, max = 25, message = "O username devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "username", length = 25, nullable = false, unique = true)
    private String username;

    // FALHA 2: Não exige complexidade (poderia ser uma senha fraca como "123")
    @Length(min = 3, max = 25, message = "A senha devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "password", length = 25, nullable = false)
    private String password;

}
