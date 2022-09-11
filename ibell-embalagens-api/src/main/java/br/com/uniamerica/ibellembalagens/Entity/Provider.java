package br.com.uniamerica.ibellembalagens.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Provider extends AbstractEntity {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String cnpjCpf;
    @Getter @Setter
    private String phoneNumber;
    @Getter @Setter
    private String addres;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private LocalDateTime dateRegister;
    @Getter @Setter
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

    public Provider(){}

    public Provider(String name, String cnpjCpf, String phoneNumber, String addres, String email,
                    LocalDateTime dateRegister, String observation){
        this.name = name;
        this.cnpjCpf = cnpjCpf;
        this.phoneNumber = phoneNumber;
        this.addres = addres;
        this.email = email;
        this.dateRegister = dateRegister;
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", cnpjCpf='" + cnpjCpf + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addres='" + addres + '\'' +
                ", email='" + email + '\'' +
                ", dateRegister=" + dateRegister +
                ", observation='" + observation + '\'' +
                '}';
    }
}
