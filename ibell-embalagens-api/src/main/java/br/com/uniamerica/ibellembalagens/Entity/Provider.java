package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Provider extends AbstractEntity{
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String cnpjCpf;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private String addres;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private LocalDateTime dateRegister;
    @Getter
    @Setter
    public String observation;



}
