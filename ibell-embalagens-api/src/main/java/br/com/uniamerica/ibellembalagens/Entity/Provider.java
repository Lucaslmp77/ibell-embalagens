package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_provider", schema = "public")
public class Provider extends AbstractEntity {
    @Getter @Setter
    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "cnpj_cpf", length = 25, nullable = false)
    private String cnpjCpf;

    @Getter @Setter
    @Column(name = "phone_number", length = 25, nullable = false)
    private String phoneNumber;

    @Getter @Setter
    @Column(name = "addres", length = 150, nullable = false)
    private String addres;

    @Getter @Setter
    @Email
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "date_register", length = 25, nullable = false)
    private LocalDateTime dateRegister;

    @Getter @Setter
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    public Provider(String name, String cnpjCpf, String phoneNumber, String addres, String email,
                    LocalDateTime dateRegister){
        this.name = name;
        this.cnpjCpf = cnpjCpf;
        this.phoneNumber = phoneNumber;
        this.addres = addres;
        this.email = email;
        this.dateRegister = dateRegister;
    }
}
