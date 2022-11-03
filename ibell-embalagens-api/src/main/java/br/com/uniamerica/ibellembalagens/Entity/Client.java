package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_client", schema = "ibell")
public class Client extends AbstractEntity {

    @Getter @Setter
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "cpf", length = 18, nullable = false, unique = true)
    private String cpf;

    @Getter @Setter
    @Column(name = "phone_number", length = 14, nullable = false)
    private String phoneNumber;

    @Getter @Setter
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Getter@Setter
    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = true)
    private String observation;

}
