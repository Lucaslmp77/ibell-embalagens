package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_client", schema = "ibell")
public class Client extends AbstractEntity {

    @Getter @Setter
    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @CPF
    @Getter @Setter
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Getter @Setter
    @Column(name = "phone_number", length = 25, nullable = false)
    private String phoneNumber;

    @Getter @Setter
    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Getter@Setter
    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    @Getter @Setter
    @ManyToMany(mappedBy = "clientList")
    private List<StockOutput> stockOutputList;

}
