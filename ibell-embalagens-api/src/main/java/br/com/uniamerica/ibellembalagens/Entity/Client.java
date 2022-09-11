package br.com.uniamerica.ibellembalagens.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class Client extends AbstractEntity {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String cpf;
    @Getter @Setter
    private String phoneNumber;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private LocalDateTime registrationDate;
    @Getter @Setter
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

    public Client(Long id, String name, String cpf, String phoneNumber, String address, LocalDateTime registrationDate,
                  String observation) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registrationDate = registrationDate;
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                ", observation='" + observation + '\'' +
                '}';
    }
}
