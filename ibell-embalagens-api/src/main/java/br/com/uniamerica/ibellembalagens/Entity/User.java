package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_user", schema = "public")
public class User extends AbstractEntity {
    @Getter @Setter
    @Length(min = 3, max = 25, message = "O login devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @Getter @Setter
    @Length(min = 3, max = 25, message = "A senha devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "password", length = 25, nullable = false)
    private String password;

    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
