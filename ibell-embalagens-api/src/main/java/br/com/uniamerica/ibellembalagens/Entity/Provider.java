package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_provider", schema = "ibell")
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
    @Column(name = "observation", length = 255, nullable = false)
    private String observation;

    @Getter @Setter
    @ManyToMany(mappedBy = "providerList")
    private List<Product> productList;

    @Getter @Setter
    @ManyToMany(mappedBy = "providerList")
    private List<StockInput> stockInputList;
}
