package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_client", schema = "public")
public class Client extends AbstractEntity {
    @Getter @Setter
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @Getter @Setter
    @CPF
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Getter @Setter
    @Column(name = "phone_number", length = 25, nullable = false)
    private String phoneNumber;

    @Getter @Setter
    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Getter @Setter
    @Column(name = "registration_date", length = 25, nullable = false)
    private LocalDateTime registrationDate;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    public Client() {}

    public Client(Long id, String name, String cpf, String phoneNumber, String address, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registrationDate = registrationDate;
    }
}
